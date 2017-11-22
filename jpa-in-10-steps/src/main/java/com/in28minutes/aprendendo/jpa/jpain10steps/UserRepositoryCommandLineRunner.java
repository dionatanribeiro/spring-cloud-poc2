package com.in28minutes.aprendendo.jpa.jpain10steps;

import com.in28minutes.aprendendo.jpa.jpain10steps.entity.User;
import com.in28minutes.aprendendo.jpa.jpain10steps.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Componentes do tipo CommandLineRunner são executados após o término da execução do contexto da
 * aplicação. Neste exemplo, ao terminar de subir a aplicação, um usuário é inserido no banco.
 */
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jill", "Admin");
        userRepository.save(user);
        log.info("new user is created: " + user);

        Optional<User> loadedUser = userRepository.findById(user.getId());
        log.info("user is retrieved: " + loadedUser);

        List<User> users = userRepository.findAll();
        log.info("all users retrieved: " + users);

    }
}
