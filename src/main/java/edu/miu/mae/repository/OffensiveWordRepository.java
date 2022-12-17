package edu.miu.mae.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffensiveWordRepository extends CrudRepository<edu.miu.mae.entity.OffensiveWord,Integer> {
}
