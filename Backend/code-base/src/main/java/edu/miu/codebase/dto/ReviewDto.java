package edu.miu.codebase.dto;

import edu.miu.codebase.entity.Product;
import edu.miu.codebase.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReviewDto {
    private int id;
    private String comment;
    private User user;
    private Product product;
}
