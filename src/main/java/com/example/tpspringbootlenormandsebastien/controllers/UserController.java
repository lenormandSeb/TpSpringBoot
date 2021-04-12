package com.example.tpspringbootlenormandsebastien.controllers;

import com.example.tpspringbootlenormandsebastien.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.BASE_ROUTE)
public class UserController extends BaseCrudController<User> {
    
    public static final String TEMPLATE_NAME = "user";
    public static final String BASE_ROUTE = "user";
    public UserController()
    {
        super(TEMPLATE_NAME);
    }
}
