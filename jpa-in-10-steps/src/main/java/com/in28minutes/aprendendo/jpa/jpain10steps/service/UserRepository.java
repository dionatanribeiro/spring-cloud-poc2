package com.in28minutes.aprendendo.jpa.jpain10steps.service;

import com.in28minutes.aprendendo.jpa.jpain10steps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}