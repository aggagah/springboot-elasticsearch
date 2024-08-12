package com.aggagah.elasticsearch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "products")
public class Product {
    @Id // gunakan tipe string agar autogenerate oleh elasticsearch
    private String id;
    private String name;
    private String description;
    private int quantity;
    private double price;
}
