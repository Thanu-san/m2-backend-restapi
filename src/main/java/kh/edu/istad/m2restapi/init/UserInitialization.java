package kh.edu.istad.m2restapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istad.m2restapi.model.User;
import kh.edu.istad.m2restapi.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserInitialization {

    private final UserRepository userRepository;

    public UserInitialization(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void init() {
        log.info("Initializing user data...");

        User user1 = new User();
        user1.setName("General Manager");
        user1.setUsername("manager");
        user1.setPassword("qwer12344");
        user1.setIsActive(true);

        User user2 = new User();
        user2.setName("Customer");
        user2.setUsername("customer");
        user2.setPassword("qwer12344");
        user2.setIsActive(true);

        User user3 = new User();
        user3.setName("Manager");
        user3.setUsername("admin");
        user3.setPassword("qwer12344");
        user3.setIsActive(true);

        if (userRepository.count() == 0) {
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        }
    }
}
