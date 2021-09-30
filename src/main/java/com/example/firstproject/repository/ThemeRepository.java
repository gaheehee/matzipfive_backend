package com.example.firstproject.repository;

import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

    List<Theme> findAllByUser(User byId);
}
