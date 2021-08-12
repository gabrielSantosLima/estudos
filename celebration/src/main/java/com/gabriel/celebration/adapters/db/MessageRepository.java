package com.gabriel.celebration.adapters.db;

import com.gabriel.celebration.domain.entities.Message;
import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.IMessageRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository extends AbstractRepository implements IMessageRepository {

    @Autowired
    private DSLContext create;

    @Override
    public Message create(Message message) {
        create.insertInto(
                table("messages"),
                field("content"),
                field("email_receiver"),
                field("user_id")
        )
                .values(
                        message.getContent(),
                        message.getEmailReceiver(),
                        message.getUserId())
                .execute();
        return message;
    }

    @Override
    public boolean deleteAll() {
        create.delete(table("messages"))
                .execute();
        return true;
    }

    @Override
    public Optional<Message> findById(int id) {
        Optional<Message> message = create.select()
                .from(table("messages"))
                .where("id = ?", id)
                .fetchOptionalInto(Message.class);
        return message;
    }

    @Override
    public List<Message> findByUserId(int userId) {
        List<Message> messages = create.select()
                .from(table("messages"))
                .where("user_id = ?", userId)
                .fetchInto(Message.class);
        return messages;
    }
}
