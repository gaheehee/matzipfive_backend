package com.example.firstproject.repository;

import com.example.firstproject.model.Card;
import jdk.nashorn.internal.ir.JoinPredecessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
