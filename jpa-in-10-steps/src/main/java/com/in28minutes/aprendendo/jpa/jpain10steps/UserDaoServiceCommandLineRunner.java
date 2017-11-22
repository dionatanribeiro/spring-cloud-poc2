package com.in28minutes.aprendendo.jpa.jpain10steps;

import com.in28minutes.aprendendo.jpa.jpain10steps.entity.User;
import com.in28minutes.aprendendo.jpa.jpain10steps.service.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Autowired
    private UserDaoService userDaoService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack", "Admin");
        Long idUser = userDaoService.insert(user);
        log.info("new user is created: " + user);
    }
}
