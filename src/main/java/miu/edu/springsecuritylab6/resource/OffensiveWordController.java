package miu.edu.springsecuritylab6.resource;


import miu.edu.springsecuritylab6.aspect.OffensiveWord;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OffensiveWordController {

    @PostMapping("/check")
    @OffensiveWord
    public List<String> checkOffensiveWords(@RequestBody List<String> words){
        return words;
    }
}
