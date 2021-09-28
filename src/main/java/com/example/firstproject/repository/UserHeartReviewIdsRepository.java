package com.example.firstproject.repository;

import com.example.firstproject.model.UserHeartReviewIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHeartReviewIdsRepository extends JpaRepository<UserHeartReviewIds, Integer> {
    List<UserHeartReviewIds> findAllByUserId(String userId);
}