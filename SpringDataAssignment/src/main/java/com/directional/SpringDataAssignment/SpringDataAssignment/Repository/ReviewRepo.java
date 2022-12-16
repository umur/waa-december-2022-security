package com.directional.SpringDataAssignment.SpringDataAssignment.Repository;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Long> {

}
