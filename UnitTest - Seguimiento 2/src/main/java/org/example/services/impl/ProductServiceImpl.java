package org.example.services.impl;

import org.example.domain.enums.ProductType;
import org.example.domain.models.Product;
import org.example.services.ProductService;

import java.util.Comparator;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    public List<Product> listByPriceByCategory(List<Product> products, ProductType type) {
        return products.stream()
                .filter(p -> p.getPrice()>100)
                .filter(p -> p.getCategory().equals(type))
                .toList();
    }
    public List<Product> listByCategoryTotal(List<Product> productsUnited, ProductType type) {
        return productsUnited.stream()
                .filter(p -> p.getCategory().equals(type))
                .toList();
    }
    public List<Product> listToys(List<Product> products, ProductType type) {
        return products.stream()
                .filter(p -> p.getCategory().equals(type))
                .map(p -> {
                    p.setPrice(p.getPrice() - p.getPrice() * 0.10);
                    return p;})
                .toList();
    }
    public List<Product> listCheapProduct(List<Product> products, ProductType type) {
        return products.stream()
                .filter(p -> p.getCategory().equals(type))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(1)
                .toList();
    }

    public Product listExpensiveProduct(List<Product> productsUnited) {
        return productsUnited.stream()
                .max(Comparator.comparing(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);
    }
}
