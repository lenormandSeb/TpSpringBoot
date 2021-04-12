package com.example.tpspringbootlenormandsebastien.controllers;

import com.example.tpspringbootlenormandsebastien.entities.Books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(BooksController.BASE_ROUTE)
public class BooksController extends BaseCrudController<Books> {
    
    public static final String TEMPLATE_NAME = "books";
    public static final String BASE_ROUTE = "books";

    public BooksController()
    {
        super(TEMPLATE_NAME);
    }
}
