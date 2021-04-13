package com.example.tpspringbootlenormandsebastien.controllers;

import java.util.List;

import com.example.tpspringbootlenormandsebastien.entities.BaseEntity;
import com.example.tpspringbootlenormandsebastien.entities.Livres;
import com.example.tpspringbootlenormandsebastien.entities.Role;
import com.example.tpspringbootlenormandsebastien.entities.User;
import com.example.tpspringbootlenormandsebastien.services.LivresService;
import com.example.tpspringbootlenormandsebastien.services.RoleService;
import com.example.tpspringbootlenormandsebastien.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class BaseCrudController<T extends BaseEntity, DTO>{

    protected static final String INDEX_ROUTE = "/index";
    protected static final String CREATE_ROUTE = "/create";
    protected static final String DETAILS_ROUTE = "/show/{id}";
    protected static final String DETAILS_TEMPLATE = "/show";
    protected static final String CONNECT_ROUTE = "/connect/${id}";
    private final String REDIRECT_INDEX;
    private final String TEMPLATE_NAME;

    public BaseCrudController(String template_name)
    {
        this.TEMPLATE_NAME = template_name;
        this.REDIRECT_INDEX = "redirect:" + "/" + this.TEMPLATE_NAME + INDEX_ROUTE;
    }

    @Autowired
    private JpaRepository<T, Long> repository;

    @Autowired
    protected LivresService livresService;

    @Autowired
    protected RoleService roleService;

    @Autowired
    protected UserService userService;

    abstract public void preIndex(Model model);
    abstract public void preShow(Long id, Model model);
    abstract public void preCreate(final Model model);

    @SuppressWarnings("unchecked")
    protected T preCreatePost(DTO dto) {
        return (T) dto;
    }

    @GetMapping(value = {"", "/", "/index"})
    public String index(final Model model) {
        if(repository.findAll().size() == 0 && TEMPLATE_NAME == "user")
        {
            model.addAttribute("count", 0);
            return "/" + "user" + "/generate";
        }

        this.preIndex(model);
        model.addAttribute("items", repository.findAll());

        return "/" + TEMPLATE_NAME + INDEX_ROUTE;
    }

    @GetMapping(value = {DETAILS_ROUTE})
    public String details(@PathVariable final Long id, final Model model)
    {
        String result = this.REDIRECT_INDEX;

        T item = this.repository.findById(id).orElse(null);

        this.preShow(id, model);

        if(item != null) {
            model.addAttribute("item", item);
            result = "/" + this.TEMPLATE_NAME + DETAILS_TEMPLATE;
        }

        return result;
    }

    @GetMapping(value = "/create")
    public String create(final Model model)
    {
        model.addAttribute("roles", this.roleService.findAll());
        return "/" + this.TEMPLATE_NAME + "/create";
    }

    @GetMapping(value = "/updateData")
    public String generate(final Model model) {
        List<Livres> book = this.livresService.generateBook();
        List<Role> role = this.roleService.generateRole();
        List<User> user = this.userService.generateUser(role, book);
        model.addAttribute("book", book.size());
        model.addAttribute("role", role.size());
        model.addAttribute("user", user.size());
        model.addAttribute("rolelist", role);
        return "/" + "user" + "/updateData";
    }

    @PostMapping(value = {CREATE_ROUTE})
    public String createPost(final DTO dto) {
        T item = this.preCreatePost(dto);

        this.repository.save(item);
        
        return this.REDIRECT_INDEX;
    }
}
