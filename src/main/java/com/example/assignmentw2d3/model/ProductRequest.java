package com.example.assignmentw2d3.model;

import com.example.assignmentw2d3.entity.User;
import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private int price;
    private User user;
}
