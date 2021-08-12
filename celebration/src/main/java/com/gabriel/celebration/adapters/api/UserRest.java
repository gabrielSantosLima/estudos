package com.gabriel.celebration.adapters.api;

import com.gabriel.celebration.domain.entities.User;
import com.gabriel.celebration.domain.ports.IUserRepository;
import com.gabriel.celebration.domain.services.CreateUsers;
import com.gabriel.celebration.domain.services.DeleteAllUsers;
import com.gabriel.celebration.domain.services.FetchAllUsers;
import com.gabriel.celebration.domain.services.FindUserById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRest {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping
    public List<User> fetchAll(){
        FetchAllUsers fetchAllUsers = new FetchAllUsers(userRepository);
        List<User> users = fetchAllUsers.execute();
        return users;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        CreateUsers createUsers = new CreateUsers(userRepository);
        createUsers.execute(user);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping
    public ResponseEntity<User> deleteAll(){
        DeleteAllUsers deleteAllUsers = new DeleteAllUsers(userRepository);
        deleteAllUsers.execute();
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id) throws Exception {
        FindUserById findUserById = new FindUserById(userRepository);
        User user = findUserById.execute(id);
        return user;
    }

}
