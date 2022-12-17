package edu.miu.mae.controller;

import edu.miu.mae.dto.UserDto;
import edu.miu.mae.entity.User;
import edu.miu.mae.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController<User, UserDto> {
    @Autowired
    public UserController(UserService us){
        this.bs = us;
    }
}