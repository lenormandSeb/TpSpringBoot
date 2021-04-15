package com.example.tpspringbootlenormandsebastien.controllers;

import com.example.tpspringbootlenormandsebastien.dtos.UserDto;
import com.example.tpspringbootlenormandsebastien.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ConnectedUserController.BASE_ROUTE)
public class ConnectedUserController extends BaseCrudController<User, UserDto> {
    
    public static final String TEMPLATE_NAME = "session";
    public static final String BASE_ROUTE = "session";

    public ConnectedUserController()
    {
        super(TEMPLATE_NAME);
    }

    @GetMapping(value = {"", "/", "/index"})
    public String index(final Model model)
    {
        String userid = (String) model.getAttribute("sessionUser");

        model.addAttribute("us", userid);
        return "/" + TEMPLATE_NAME + "/index";
    }

    @Override
    public void preIndex(Model model) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preShow(Long id, Model model) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preCreate(Model model) {
        // TODO Auto-generated method stub
        
    }
}
