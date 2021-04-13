package com.example.tpspringbootlenormandsebastien.controllers;

import com.example.tpspringbootlenormandsebastien.dtos.LivresDto;
import com.example.tpspringbootlenormandsebastien.entities.Livres;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(LivresController.BASE_ROUTE)
public class LivresController extends BaseCrudController<Livres, LivresDto> {
    
    public static final String TEMPLATE_NAME = "livres";
    public static final String BASE_ROUTE = "livres";

    public LivresController()
    {
        super(TEMPLATE_NAME);
    }

    @Override
    public void preIndex(Model model) {
        
    }

    @Override
    public void preShow(Long id, Model model) {
        
    }

    @Override
    public void preCreate(Model model) {
        
    }

    @Override
    protected Livres preCreatePost(LivresDto dto) {
        Livres book = new Livres();
        book.setBookName(dto.getBookName());
        book.setNbPage(dto.getNbPage());
        book.setPrice(dto.getPrice());
        book.setImg("histoiresansfin.jpg");

        return book;
    }
}
