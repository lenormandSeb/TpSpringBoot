package com.example.tpspringbootlenormandsebastien.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.tpspringbootlenormandsebastien.entities.User;
import com.example.tpspringbootlenormandsebastien.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> generateUser()
    {
        List<User> user = new ArrayList<User>();
        Random rand = new Random();
        int i = rand.nextInt(20);
        for(int j = 0; j < i; j++) {
            User u = new User();
            u.setFirstName("Firstname" + j);
            u.setLastName("Lastname" + j);
            user.add(u);
            this.repository.save(u);
        }

        //Save data before return list
        if (user.size() == 0)
        {
            this.generateUser();
        }
        return user;

    }

    public List<User> findAll()
    {
        return this.repository.findAll();
    }
}
