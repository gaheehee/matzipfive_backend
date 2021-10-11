package com.example.firstproject.testRepository;

import com.example.firstproject.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeTestRepository extends JpaRepository<Theme, Integer> {

    List<Theme> findAllByUserId(String userId);
}
