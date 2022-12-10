package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
//    List<Review> findAllByProduct_Id(int id);
}
