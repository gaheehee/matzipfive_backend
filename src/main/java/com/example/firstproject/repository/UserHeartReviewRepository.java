package com.example.firstproject.repository;

import com.example.firstproject.model.UserHeartReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserHeartReviewRepository extends JpaRepository<UserHeartReview, Integer> {

    List<UserHeartReview> findAllByUserId(String userId);

    @Transactional
    void deleteByUserIdAndReviewId(String userId, Integer reviewId);

    List<Integer> findReviewIdsByUserId(String userId);
}
