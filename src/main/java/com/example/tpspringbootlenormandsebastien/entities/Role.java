package com.example.tpspringbootlenormandsebastien.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity{
    
    @Column(nullable = false)
    private String roleName;


    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
