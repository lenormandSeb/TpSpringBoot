package com.example.tpspringbootlenormandsebastien.repositories;

import java.util.List;

import com.example.tpspringbootlenormandsebastien.dtos.RoleCount;
import com.example.tpspringbootlenormandsebastien.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery= true,value="SELECT r.role_name AS roleName, COUNT(*) AS num FROM User u INNER JOIN Role r ON u.role_id = r.id GROUP BY role_id")
    List<RoleCount> findAllGroupByRole();

    @Query(nativeQuery = true, value ="SELECT * FROM User WHERE role_id = ?1")
    List<User> findUserWithRole(Long id);
}
