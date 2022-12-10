package com.miu.springsecurity.dto;

import com.miu.springsecurity.entity.Product;
import com.miu.springsecurity.entity.User;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String comment;
    private Product product;
    private User user;
}
