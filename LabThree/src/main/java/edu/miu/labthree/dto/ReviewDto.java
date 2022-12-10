package edu.miu.labthree.dto;

import edu.miu.labthree.entity.Product;
import edu.miu.labthree.entity.User;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private int comment;
    private Product product;
    private User user;
}
