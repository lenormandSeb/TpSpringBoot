package com.example.tpspringbootlenormandsebastien.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Livres extends BaseEntity{
    
    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private Integer nbPage;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = true)
    private String img;

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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
        BigDecimal bigDecimal = new BigDecimal(Float.toString(this.price));
        return bigDecimal.setScale(2, RoundingMode.HALF_UP).floatValue();
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
