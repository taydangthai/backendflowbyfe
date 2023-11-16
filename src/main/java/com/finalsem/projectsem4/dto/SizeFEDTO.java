package com.finalsem.projectsem4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SizeFEDTO {
    private Long id;
    private String name;
    private double screenSize;
    private double price;
    private int stock;

    public SizeFEDTO(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }
}
