package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
