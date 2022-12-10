package edu.miu.labthree.controller;

import edu.miu.labthree.dto.UserDto;
import edu.miu.labthree.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user list")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto userDto){
        userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "User deleted";
    }
}
