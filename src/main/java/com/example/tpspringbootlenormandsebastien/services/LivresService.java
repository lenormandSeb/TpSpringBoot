package com.example.tpspringbootlenormandsebastien.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.tpspringbootlenormandsebastien.entities.Livres;
import com.example.tpspringbootlenormandsebastien.repositories.LivresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivresService {
    @Autowired
    private LivresRepository repository;

    public List<Livres> generateBook()
    {
        List<Livres> book = new ArrayList<Livres>();
        Random rand = new Random();
        int i = rand.nextInt(42);
        for(int j = 0; j < i; j++)
        {
            Livres bok = new Livres();
            bok.setBookName("Mon Super Livre Tome " + j);
            int nPage = rand.nextInt(600);
            bok.setNbPage(nPage);
            float price = rand.nextFloat() * 100;
            bok.setPrice(price);
            bok.setImg("histoiresansfin.jpg");
            this.repository.save(bok);
            book.add(bok);
        }
        return book;
        
    }

    public List<Livres> findAll()
    {
        return this.repository.findAll();
    }
}
