package com.example.tpspringbootlenormandsebastien.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.example.tpspringbootlenormandsebastien.entities.Books;
import com.example.tpspringbootlenormandsebastien.entities.Role;
import com.example.tpspringbootlenormandsebastien.entities.User;
import com.example.tpspringbootlenormandsebastien.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> generateUser(List<Role> role, List<Books> book)
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

    public Map<String, Integer> getUserByRole()
    {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        List<User> users = this.repository.findAll();
        for(User user : users){
            Integer j = hm.get(user.getRole().getRoleName());
            hm.put(user.getRole().getRoleName(), (j == null) ? 1 : j + 1);
        }
        return hm;
    }
}
