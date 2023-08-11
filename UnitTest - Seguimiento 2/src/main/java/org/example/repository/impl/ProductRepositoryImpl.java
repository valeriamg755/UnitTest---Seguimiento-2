package org.example.repository.impl;

import org.example.domain.enums.ProductType;
import org.example.domain.models.Product;
import org.example.mapping.dtos.ProductDto;
import org.example.mapping.mappers.ProductMapper;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;
    private List<Product> productsA;
    private List<Product> productsB;
    private List<List<Product>> productsTotal;
    private List<Product> productsUnited;

    public List<Product> getProductsUnited() {
        return productsUnited;
    }

    public void setProductsUnited(List<Product> productsUnited) {
        this.productsUnited = productsUnited;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductRepositoryImpl() {

        Product product1 = new Product(101, "Omniscent Reader's Viewpoint", ProductType.BOOK, 50000.0);
        Product product2 = new Product(202, "Interestellar", ProductType.MOVIE, 50000.0);
        Product product3 = new Product(303, "Laptop", ProductType.ELECTRONICS, 2500000.0);
        Product product4 = new Product(404, "No Longer Human", ProductType.BOOK, 68000.0);
        Product product5 = new Product(505, "Suzume", ProductType.MOVIE, 100000.0);
        Product product6 = new Product(606, "Tablet", ProductType.ELECTRONICS, 1500000.0);
        Product product7 = new Product(707, "Scorpio City", ProductType.BOOK, 45000.0);
        Product product8 = new Product(808, "Barbie", ProductType.MOVIE, 150000.0);
        Product product9 = new Product(909, "Smartphone", ProductType.ELECTRONICS, 2000000.0);
        Product product10 = new Product(1010, "Three Ways to Survive in a Ruined World 'Limited Edition'",
                ProductType.BOOK, 186300.0);

        products = new ArrayList<Product>();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        productsA = new ArrayList<Product>();
        productsA.add(product1);
        productsA.add(product2);

        productsB = new ArrayList<Product>();
        productsB.add(product1);
        productsB.add(product3);
        productsB.add(product4);

        productsTotal = Arrays.asList(productsA, productsB);

        productsUnited = productsTotal.stream()
                .flatMap(list -> list.stream())
                .collect(toList());
    }

    @Override
    public List<ProductDto> listAllProduct() {
        return ProductMapper.mapFrom(products);
    }

    @Override
    public List<ProductDto> listAllProductsA() {
        return ProductMapper.mapFrom(productsA);
    }

    @Override
    public List<ProductDto> listAllProductsB() {
        return ProductMapper.mapFrom(productsB);
    }

    @Override
    public List<ProductDto> listAllProductsUnited() {
        return ProductMapper.mapFrom(productsUnited);
    }
}