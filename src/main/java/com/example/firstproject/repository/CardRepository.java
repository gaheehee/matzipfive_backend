package com.example.firstproject.repository;

import com.example.firstproject.model.Card;
import jdk.nashorn.internal.ir.JoinPredecessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    List<Card> findAllByThemeId(Integer themeId);
}
