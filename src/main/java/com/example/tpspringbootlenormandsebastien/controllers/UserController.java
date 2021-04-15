package com.example.tpspringbootlenormandsebastien.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.example.tpspringbootlenormandsebastien.dtos.UserDto;
import com.example.tpspringbootlenormandsebastien.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(UserController.BASE_ROUTE)
public class UserController extends BaseCrudController<User, UserDto> {
    
    public static final String TEMPLATE_NAME = "user";
    public static final String BASE_ROUTE = "user";
    protected static final String CONNECT_ROUTE = "/connect/{id}";

    public UserController()
    {
        super(TEMPLATE_NAME);
    }

    @Override
    public void preIndex(Model model) {
    }

    @GetMapping(value = {CONNECT_ROUTE})
    public String connectAsUser(@PathVariable final Long id, final Model model, final HttpServletResponse response, final RedirectAttributes attributes)
    {
        try {
            Cookie cookie = new Cookie("userid", "user-id-" + id);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            attributes.addFlashAttribute(FLASH_ERROR, e.getMessage());
        }
        return "redirect:" + "/" + "user" + "/index";
    }

    @GetMapping(value = "/donjonDeNaheulbeuk")
    public String nopePage(final Model model) {
        model.addAttribute("count", 1);
        return "/" + TEMPLATE_NAME + "/generate";
    }

    @Override
    public void preShow(Long id, Model model) {
    }

    @Override
    public void preCreate(Model model) {
        
    }

    @Override
    protected User preCreatePost(UserDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        if(dto.getRole() != null) {
            user.setRole(this.roleService.findRole(dto.getRole().getId()));
        }

        return user;
    }
}
