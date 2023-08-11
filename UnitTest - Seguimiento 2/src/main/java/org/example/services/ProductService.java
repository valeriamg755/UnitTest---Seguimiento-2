package org.example.services;

import org.example.domain.enums.ProductType;
import org.example.domain.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> listByPriceByCategory(List<Product> products, ProductType type);
    List<Product> listByCategoryTotal(List<Product> productsUnited, ProductType type);
    List<Product> listToys(List<Product> products, ProductType type);
    List<Product> listCheapProduct(List<Product> products, ProductType type);
    Product listExpensiveProduct(List<Product> productsUnited);

}
