package com.example.tpspringbootlenormandsebastien.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Books extends BaseEntity{
    
    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private Integer nbPage;

    @Column(nullable = false)
    private Float price;

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getNbPage() {
        return this.nbPage;
    }

    public void setNbPage(Integer nbPage) {
        this.nbPage = nbPage;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
