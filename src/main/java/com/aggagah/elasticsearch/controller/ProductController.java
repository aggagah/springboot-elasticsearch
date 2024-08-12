package com.aggagah.elasticsearch.controller;


import com.aggagah.elasticsearch.dto.request.UpdateProductRequestDto;
import com.aggagah.elasticsearch.model.Product;
import com.aggagah.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> getProducts(){
        Iterable<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> insertProduct(@RequestBody Product product){
        Product product1 = productService.insertProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody UpdateProductRequestDto productRequestDto, @PathVariable String id){
//        System.out.println("ID : "+id);
        return new ResponseEntity<>(productService.updateProduct(productRequestDto, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detailProduct(@PathVariable String id){
        return new ResponseEntity<>(productService.detailProduct(id), HttpStatus.OK);
    }
}
