package com.aggagah.elasticsearch.service.impl;

import com.aggagah.elasticsearch.dto.request.UpdateProductRequestDto;
import com.aggagah.elasticsearch.model.Product;
import com.aggagah.elasticsearch.repository.ProductRepository;
import com.aggagah.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UpdateProductRequestDto productRequestDto, String id) {
        Product product1 = productRepository.findById(id).orElse(null);

        if(product1 == null){
            throw new IllegalArgumentException("no data with given id");
        }

        product1.setPrice(productRequestDto.getPrice());
        product1.setName(productRequestDto.getName());
        product1.setDescription(productRequestDto.getDescription());
        product1.setQuantity(productRequestDto.getQuantity());
        return productRepository.save(product1);
    }

    @Override
    public Iterable<Product> deleteProduct(String id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @Override
    public Product detailProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }
}
