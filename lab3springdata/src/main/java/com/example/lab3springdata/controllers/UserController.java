package com.example.lab3springdata.controllers;

import com.example.lab3springdata.dto.userDto.UserBasicDto;
import com.example.lab3springdata.entity.User;
import com.example.lab3springdata.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/useres")
@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {

        this.userService = userService;
    }

    @GetMapping
    public List<UserBasicDto> getAll(){

        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UserBasicDto getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody UserBasicDto userDto){
        userService.save(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserBasicDto userDto){
        userService.update(id,userDto);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "deleted";
    }



}
