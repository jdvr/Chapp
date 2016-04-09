package es.juandavidvega.repository;

import es.juandavidvega.output.ChatMessage;
import es.juandavidvega.output.ChatMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("chatMessageRepository")
public class JDBCChatMessageRepository implements ChatMessageRepository {

    static final String CreateQuery = "insert into message (content, sender, sendDate) values (?, ?, ?)";
    static final String FindAllQuery = "select content, sender, sendDate from message";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCChatMessageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void save(ChatMessage message) {
        jdbcTemplate.update(
                CreateQuery,
                message.getContent(),
                message.getSendDate(),
                message.getSendDate());
    }

    @Override
    public ChatMessages loadChannelMessages() {
        return jdbcTemplate.queryForObject(
                FindAllQuery,
                this::createMessagesFromResult
        );
    }

    private ChatMessages createMessagesFromResult(ResultSet resultSet, int rowNumber) {
        ChatMessages messages = new ChatMessages();
        try {
            while (resultSet.next()){
                messages.add(new ChatMessage(
                        resultSet.getString("content"),
                        resultSet.getString("sender"),
                        resultSet.getDate("sendDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  messages;
    }
}
