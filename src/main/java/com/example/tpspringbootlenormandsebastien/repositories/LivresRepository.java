package com.example.tpspringbootlenormandsebastien.repositories;

import com.example.tpspringbootlenormandsebastien.entities.Livres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivresRepository extends JpaRepository<Livres, Long>{

}
