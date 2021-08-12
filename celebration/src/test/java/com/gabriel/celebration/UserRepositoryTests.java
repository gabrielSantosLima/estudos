package com.gabriel.celebration;

import com.gabriel.celebration.adapters.db.UserRepository;
import com.gabriel.celebration.domain.entities.User;
import org.jooq.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTests {

	@Autowired
	private DSLContext dslContext;

	@Autowired
	private UserRepository userRepository;

	@Test
	void emailShouldBeEqualsTesteGmail() {
		User user = dslContext.select()
				.from("users")
				.where("name = ?", "Gabriel Lima")
				.fetchAnyInto(User.class);
		Assertions.assertEquals("teste@gmail.com", user.getEmail());
	}

	@Test
	void userShouldBeCreated(){
		User user = new User(0, "Felipe Lima", "teste@gmail.com");
		Assertions.assertDoesNotThrow(() -> {
			userRepository.create(user);
		});
	}

	@Test
	void userShouldBeFoundById(){
		int id = 1;
		String expectedUserName = "Gabriel Lima";
		Assertions.assertEquals(expectedUserName, userRepository.findById(id).get().getName());
	}
}
