package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.UserService;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.Persons;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {


    public final UserService addressService;

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
       return addressService.getById(id);
    }

    @GetMapping
    public List<User> GetAll() {
       return addressService.getAll();
    }

    @PostMapping
    public void add(@RequestBody User user) {
        addressService.saveOrUpdate(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        addressService.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

    @GetMapping("/persons")
    public List<Persons> getAllPersons() {
        Persons persons = new Persons(1, "John", "Doe","test@test1","1");
        Persons persons1 = new Persons(2, "Rikcy", "Martin","test@test1","1");
        Persons persons2 = new Persons(3, "Dummy", "Person","test@test1","1");
        List<Persons> users = Arrays.asList(persons, persons1, persons2);
        return users;
    }
}
