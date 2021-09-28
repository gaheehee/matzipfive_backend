package com.example.firstproject.repository;

import com.example.firstproject.model.ThemeCardIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ThemeCardIdsRepository extends JpaRepository<ThemeCardIds, Integer> {

    List<ThemeCardIds> findAllByThemeId(Integer themeId);

    @Transactional
    void deleteAllByThemeId(Integer themeId);
}
