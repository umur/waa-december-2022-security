package com.example.lab6.DTO;

import com.example.lab6.Aspects.waaWord;
import lombok.Data;

import java.time.Instant;

@Data
public class ProductDTO {
    private Long id;
    @waaWord
    private String name;
    private Double price;

    private Instant createdAt;
    private Long createdBy;
    private Instant updatedAt;
    private Long updatedBy;
}
