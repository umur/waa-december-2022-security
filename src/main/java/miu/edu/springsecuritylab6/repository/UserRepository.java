package miu.edu.springsecuritylab6.repository;


import miu.edu.springsecuritylab6.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);

}
