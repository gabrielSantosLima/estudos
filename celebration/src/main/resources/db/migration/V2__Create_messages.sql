CREATE TABLE messages(
    id SERIAL NOT NULL,
    content VARCHAR NOT NULL,
    email_receiver VARCHAR(100) NOT NULL,
    user_id SERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(user_id) REFERENCES users(id)
);