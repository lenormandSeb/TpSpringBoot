package com.example.tpspringbootlenormandsebastien.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.tpspringbootlenormandsebastien.entities.Books;
import com.example.tpspringbootlenormandsebastien.repositories.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    @Autowired
    private BooksRepository repository;

    public List<Books> generateBook()
    {
        List<Books> book = new ArrayList<Books>();
        Random rand = new Random();
        int i = rand.nextInt(42);
        for(int j = 0; j < i; j++)
        {
            Books bok = new Books();
            bok.setBookName("Mon Super Livre Tome " + j);
            int nPage = rand.nextInt(600);
            bok.setNbPage(nPage);
            float price = rand.nextFloat() * 100;
            bok.setPrice(price);
            this.repository.save(bok);
            book.add(bok);
        }
        return book;
        
    }

    public List<Books> findAll()
    {
        return this.repository.findAll();
    }
}
