package com.aggagah.elasticsearch.service;

import com.aggagah.elasticsearch.dto.request.UpdateProductRequestDto;
import com.aggagah.elasticsearch.model.Product;


public interface ProductService {
    Iterable<Product> getProducts();
    Product insertProduct(Product product);
    Product updateProduct(UpdateProductRequestDto productRequestDto, String id);
    Iterable<Product> deleteProduct(String id);
    Product detailProduct(String id);
}
