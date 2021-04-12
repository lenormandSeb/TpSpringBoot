package com.example.tpspringbootlenormandsebastien.services;

import java.util.List;

import com.example.tpspringbootlenormandsebastien.entities.Books;
import com.example.tpspringbootlenormandsebastien.repositories.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class BooksService {
    @Autowired
    private BooksRepository repository;

    public List<Books> findAll()
    {
        return this.repository.findAll();
    }
}
