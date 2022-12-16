package com.example.lab6.Service;


import java.util.Map;

public interface uaaService {
    Map<String, String> login(Map<String, String> body);

    Map<String, String> refresh(String token);
    Map<String, Boolean> validate();
}