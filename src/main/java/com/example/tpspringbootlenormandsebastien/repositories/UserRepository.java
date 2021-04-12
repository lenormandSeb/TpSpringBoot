package com.example.tpspringbootlenormandsebastien.repositories;

import com.example.tpspringbootlenormandsebastien.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
