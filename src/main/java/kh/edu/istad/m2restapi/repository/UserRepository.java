package kh.edu.istad.m2restapi.repository;

import kh.edu.istad.m2restapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();

        User userAdmin = new User(UUID.randomUUID(), "Administrator","admin_Thanu", "1234", true );
        User userEditor = new User(UUID.randomUUID(), "Editor" ,"editor_Thana", "e1234",  true);
        User userCustomer = new User(UUID.randomUUID(), "Customer", "customer_Oudom", "c1234", true);
        users.add(userAdmin);
        users.add(userCustomer);
        users.add(userEditor);
    }

    public List<User> selectAll() {
        return users;
    }

    public Optional<User> selectById(UUID id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void insert(User user) {
        users.add(user);
    }

    public void deleteById(UUID id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
