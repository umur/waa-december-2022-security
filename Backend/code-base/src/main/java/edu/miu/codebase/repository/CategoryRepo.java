package edu.miu.codebase.repository;

import edu.miu.codebase.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List<Category> findAllByNameContaining(String name);
}
