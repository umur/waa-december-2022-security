package miu.edu.springdata.repository;

import miu.edu.springdata.entity.OffensiveUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffensiveUserRepo extends CrudRepository<OffensiveUser, Integer> {
    OffensiveUser findOffensiveUserByUser_Id(int userId);
}
