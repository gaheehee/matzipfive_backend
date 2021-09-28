package com.example.firstproject.repository;

import com.example.firstproject.model.UserRegisterThemeIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRegisterThemeIdsRepository extends JpaRepository<UserRegisterThemeIds, Integer> {

    List<UserRegisterThemeIds> findAllByUserId(String userId);

    @Transactional
    void deleteByThemeId(Integer themeId);
}
