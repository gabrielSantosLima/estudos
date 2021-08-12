package com.gabriel.celebration.adapters.db;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.IUserRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository extends AbstractRepository implements IUserRepository {

    @Autowired
    private DSLContext create;

    @Override
    public List<User> fetchAll() {
        List<User> users = create.select()
                .from("users")
                .fetchInto(User.class);
        return users;
    }

    @Override
    public User create(User user) {
        create.insertInto(
                table("users"),
                field("name"),
                field("email")
        )
        .values(user.getName(), user.getEmail())
        .execute();
        return user;
    }

    @Override
    public boolean deleteAll() {
        create.delete(table("users"))
            .execute();
        return true;
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<User> user = create.select()
                .from(table("users"))
                .where("id = ?", id)
                .fetchOptionalInto(User.class);
        return user;
    }
}
