package miu.edu.springsecuritylab6.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResources {

    @GetMapping("/home")
    public String getData(){
        return "I am from home resources";
    }
}
