package com.example.tpspringbootlenormandsebastien.services;

import java.util.ArrayList;
import java.util.List;

import com.example.tpspringbootlenormandsebastien.entities.Role;
import com.example.tpspringbootlenormandsebastien.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository repository;

    public List<Role> generateRole()
    {
        List<Role> role = new ArrayList<Role>();
        Role r = new Role();
        Role r2d2 = new Role();
        r.setId((long) 1);
        r.setRoleName("Customer");
        r2d2.setId((long) 2);
        r2d2.setRoleName("Seller");
        this.repository.save(r);
        this.repository.save(r2d2);
        role.add(r);
        role.add(r2d2);

        return role;
    }

    public List<Role> findAll()
    {
        return this.repository.findAll();
    }
}
