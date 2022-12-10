package com.waa.security.aspect;


import java.io.*;

import okhttp3.*;
import org.springframework.stereotype.Component;

@Component
public class OffensiveWordChecker {
final String[] offensiveWords = {
            "test", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
    };

    public String checkOffensiveWords(String censoredBody) throws IOException {
            for (String word : offensiveWords) {
                if (censoredBody.contains(word)) {
                    return "Offensive word found " + word;
                }
            }
            return "No offensive words found";

    }
}
