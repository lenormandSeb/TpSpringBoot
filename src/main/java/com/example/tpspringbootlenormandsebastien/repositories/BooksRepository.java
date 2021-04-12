package com.example.tpspringbootlenormandsebastien.repositories;

import com.example.tpspringbootlenormandsebastien.entities.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long>{

}
