package com.example.firstproject.testRepository;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.model.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommentTestRepository extends JpaRepository<Recomment, Integer> {
    List<Recomment> findByReviewComment(Optional<ReviewComment> byId);
}

