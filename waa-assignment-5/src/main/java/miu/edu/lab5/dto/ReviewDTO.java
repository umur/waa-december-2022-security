package miu.edu.lab5.dto;

import miu.edu.lab5.entity.Product;
import miu.edu.lab5.entity.User;

import java.util.List;

public class ReviewDTO {
    private int id;
    private String comment;
    private List<Product> product;
    private User user;

}
