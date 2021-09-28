package com.example.firstproject.repository;

import com.example.firstproject.model.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommentRepository extends JpaRepository<Recomment, Integer> {
}
