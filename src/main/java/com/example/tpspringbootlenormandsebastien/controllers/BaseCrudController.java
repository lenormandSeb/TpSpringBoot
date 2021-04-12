package com.example.tpspringbootlenormandsebastien.controllers;

import java.util.List;
import java.util.Map;

import com.example.tpspringbootlenormandsebastien.entities.BaseEntity;
import com.example.tpspringbootlenormandsebastien.entities.Books;
import com.example.tpspringbootlenormandsebastien.entities.Role;
import com.example.tpspringbootlenormandsebastien.entities.User;
import com.example.tpspringbootlenormandsebastien.services.BooksService;
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

    public BaseCrudController(String template_name)
    {
        this.TEMPLATE_NAME = template_name;
        this.REDIRECT_INDEX = "redirect:" + "/" + this.TEMPLATE_NAME + INDEX_ROUTE;
    }

    @Autowired
    private JpaRepository<T, Long> repository;

    @Autowired
    private BooksService booksService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/", "/index"})
    public String index(final Model model) {
        if(repository.findAll().size() == 0 && TEMPLATE_NAME == "user")
        {
            model.addAttribute("count", 0);
            return "/" + "user" + "/generate";
        }
        if(TEMPLATE_NAME == "role") {
            Map<String, Integer> userByRole = this.userService.getUserByRole();
            model.addAttribute("roleSeller", userByRole.get("Seller"));
            model.addAttribute("roleCustomer", userByRole.get("Customer"));
        }
        model.addAttribute("page", "index");
        model.addAttribute("items", repository.findAll());

        return "/" + TEMPLATE_NAME + INDEX_ROUTE;
    }

    @GetMapping(value = "/donjonDeNaheulbeuk")
    public String nopePage(final Model model) {
        model.addAttribute("count", 1);
        return "/" + "user" + "/generate";
    }

    @GetMapping(value = "/updateData")
    public String generate(final Model model) {
        List<Books> book = this.booksService.generateBook();
        List<Role> role = this.roleService.generateRole();
        List<User> user = this.userService.generateUser(role, book);
        model.addAttribute("book", book.size());
        model.addAttribute("role", role.size());
        model.addAttribute("user", user.size());
        model.addAttribute("rolelist", role);
        return "/" + "user" + "/updateData";
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

    @GetMapping(value = "/create")
    public String create(final Model model)
    {
        model.addAttribute("roles", this.roleService.findAll());
        return "/" + this.TEMPLATE_NAME + "/create";
    }
    
}
