package miu.edu.springsecuritylab6.service;

import miu.edu.springsecuritylab6.domain.User;
import miu.edu.springsecuritylab6.exception.EmailExistException;
import miu.edu.springsecuritylab6.exception.UsernameExistException;

public interface UserService {

    User findUserByUsername(String username);
    User findUserByEmail(String username);
    User register(String firstName, String lastName, String username, String email) throws EmailExistException, UsernameExistException;

}
