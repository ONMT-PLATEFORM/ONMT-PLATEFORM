package ma.onmt.api.usersservice;

import ma.onmt.api.usersservice.dto.*;
import ma.onmt.api.usersservice.repository.RoleRepository;
import ma.onmt.api.usersservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AuthRunner {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService, RoleRepository roleRepository) {
        return args -> {
            RegisterDto user = new RegisterDto();
            user.setEmail("user1@example.ma");
            user.setPassword("1234");
            user.setFirstName("User1");
            user.setLastName("Example 1");
            user.setRegionId("1");
            userService.register(user);

            RegisterDto user1 = new RegisterDto();
            user1.setEmail("user2@example.ma");
            user1.setPassword("1234");
            user1.setFirstName("User2");
            user1.setLastName("Example 2");
            user1.setRegionId("2");
            userService.register(user1);


            RegisterDto user2 = new RegisterDto();
            user2.setEmail("user3@example.ma");
            user2.setPassword("1234");
            user2.setFirstName("User3");
            user2.setLastName("Example 3");
            user.setRegionId("2");
            userService.register(user2);

        };
    }
}
