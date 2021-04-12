package com.example.tpspringbootlenormandsebastien.controllers;

import com.example.tpspringbootlenormandsebastien.entities.BaseEntity;
import com.example.tpspringbootlenormandsebastien.services.RoleService;
import com.example.tpspringbootlenormandsebastien.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class BaseCrudController<T extends BaseEntity>{

    protected static final String INDEX_ROUTE = "/index";
    protected static final String CREATE_ROUTE = "/create";
    protected static final String DETAILS_ROUTE = "/show/{id}";
    protected static final String DETAILS_TEMPLATE = "/show";
    private final String REDIRECT_INDEX;
    private final String TEMPLATE_NAME;
    
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    // @Autowired
    // private BooksService bookService;

    public BaseCrudController(String template_name)
    {
        this.TEMPLATE_NAME = template_name;
        this.REDIRECT_INDEX = "redirect:" + "/" + this.TEMPLATE_NAME + INDEX_ROUTE;
        //Generate data User
        this.userService.generateUser();
        //Generate data Role
        this.roleService.generateRole();
        //Generate data Book
        // this.bookService.generateBook();
    }

    @Autowired
    private JpaRepository<T, Long> repository;

    @GetMapping(value = {"", "/", "/index"})
    public String index(final Model model) {
        model.addAttribute("page", "creation");
        model.addAttribute("items", repository.findAll());

        return "/" + TEMPLATE_NAME + INDEX_ROUTE;
    }

    @GetMapping(value = {DETAILS_ROUTE})
    public String details(@PathVariable final Long id, final Model model)
    {
        String result = this.REDIRECT_INDEX;

        T item = this.repository.findById(id).orElse(null);

        if(item != null) {
            model.addAttribute("item", item);
            result = "/" + this.TEMPLATE_NAME + DETAILS_TEMPLATE;
        }

        return result;
    }
    
}
