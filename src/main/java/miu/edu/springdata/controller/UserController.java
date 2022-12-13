package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.dto.UserDto;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public void save(@PathVariable int id, @RequestBody User user) {
        if (id > 0)
            user.setId(id);
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}
