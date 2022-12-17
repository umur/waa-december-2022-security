package edu.miu.mae.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class OffensiveWordDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String word;

}