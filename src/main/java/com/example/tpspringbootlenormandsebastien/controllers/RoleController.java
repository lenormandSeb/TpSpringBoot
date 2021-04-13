package com.example.tpspringbootlenormandsebastien.controllers;

import java.util.List;

import com.example.tpspringbootlenormandsebastien.dtos.RoleCount;
import com.example.tpspringbootlenormandsebastien.dtos.RoleDto;
import com.example.tpspringbootlenormandsebastien.entities.Role;
import com.example.tpspringbootlenormandsebastien.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RoleController.BASE_ROUTE)
public class RoleController extends BaseCrudController<Role, RoleDto> {
    
    public static final String BASE_ROUTE = "role";
    public static final String TEMPLATE_NAME = "role";

    public RoleController()
    {
        super(TEMPLATE_NAME);
    }

    @Override
    public void preIndex(Model model) {
        List<RoleCount> userByRole = this.userService.getUserByRole();
        model.addAttribute("roleSeller", userByRole);
    }

    @Override
    public void preShow(Long id, Model model)
    {
        List<User> roleGetUser = this.userService.getRoleGetUser(id);
        model.addAttribute("items", roleGetUser);
    }

    @Override
    public void preCreate(Model model){}

    @Override
    protected Role preCreatePost(RoleDto dto)
    {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());

        return role;
    }
}
