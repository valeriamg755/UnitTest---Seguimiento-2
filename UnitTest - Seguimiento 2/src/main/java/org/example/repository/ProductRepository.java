package org.example.repository;

import org.example.mapping.dtos.ProductDto;

import java.util.List;

public interface ProductRepository {

    List<ProductDto> listAllProduct();
    List<ProductDto> listAllProductsA();
    List<ProductDto> listAllProductsB();
    List<ProductDto> listAllProductsUnited();

}
