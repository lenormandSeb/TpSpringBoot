package com.example.tpspringbootlenormandsebastien.repositories;

import com.example.tpspringbootlenormandsebastien.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
