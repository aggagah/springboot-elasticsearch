package com.aggagah.elasticsearch.dto.request;


import lombok.Data;

@Data
public class UpdateProductRequestDto {
    private String name;
    private String description;
    private int quantity;
    private double price;

    public UpdateProductRequestDto(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
}
