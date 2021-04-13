package com.example.tpspringbootlenormandsebastien.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.tpspringbootlenormandsebastien.dtos.RoleCount;
import com.example.tpspringbootlenormandsebastien.entities.Livres;
import com.example.tpspringbootlenormandsebastien.entities.Role;
import com.example.tpspringbootlenormandsebastien.entities.User;
import com.example.tpspringbootlenormandsebastien.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> generateUser(List<Role> role, List<Livres> book)
    {
        List<User> user = new ArrayList<User>();
        Random rand = new Random();
        int i = rand.nextInt(20);
        for(int j = 0; j < i; j++) {
            User u = new User();
            int randomRole = rand.nextInt(2);
            u.setFirstName("Firstname" + j);
            u.setLastName("Lastname" + j);
            u.setRole(role.get(randomRole));
            user.add(u);
            this.repository.save(u);
        }

        //Save data before return list
        if (user.size() == 0)
        {
            this.generateUser(role, book);
        }
        return user;

    }

    public List<User> findAll()
    {
        return this.repository.findAll();
    }

    public List<RoleCount> getUserByRole()
    {
        List<RoleCount> user = this.repository.findAllGroupByRole();
        return user;
    }

    public List<User> getRoleGetUser(Long id) {
        List<User> users = this.repository.findUserWithRole(id);
        return users;
    }
}
