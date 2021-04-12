package com.example.tpspringbootlenormandsebastien.controllers;

import com.example.tpspringbootlenormandsebastien.entities.Role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RoleController.BASE_ROUTE)
public class RoleController extends BaseCrudController<Role> {
    
    public static final String BASE_ROUTE = "role";
    public static final String TEMPLATE_NAME = "role";

    public RoleController()
    {
        super(TEMPLATE_NAME);
    }
}
