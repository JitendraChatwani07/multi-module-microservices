package com.sarvika.technologies.assignment.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarvika.technologies.assignment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

