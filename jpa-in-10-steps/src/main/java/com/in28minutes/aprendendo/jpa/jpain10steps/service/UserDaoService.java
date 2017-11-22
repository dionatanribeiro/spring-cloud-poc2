package com.in28minutes.aprendendo.jpa.jpain10steps.service;

import com.in28minutes.aprendendo.jpa.jpain10steps.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoService {

    @PersistenceContext
    private EntityManager entityManager;

    public Long insert(User user) {
        // Open transaction
        entityManager.persist(user);

        // Close transaction
        return user.getId();
    }

}
