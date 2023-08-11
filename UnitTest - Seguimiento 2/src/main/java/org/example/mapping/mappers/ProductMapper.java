package org.example.mapping.mappers;

import org.example.domain.models.Product;
import org.example.mapping.dtos.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDto mapFrom(Product source){
        return new ProductDto(source.getId(),
                source.getName(),
                source.getCategory(),
                source.getPrice());
    }
    public static Product mapFrom(ProductDto source){
        return new Product(source.id(),
                source.name(),
                source.category(),
                source.price());
    }
    public static List<ProductDto> mapFrom(List<Product> source){
        return source.stream().map(ProductMapper::mapFrom).collect(Collectors.toList());
    }
    public static List<Product> mapFromDto(List<ProductDto> source){
        return source.stream().map(ProductMapper::mapFrom).collect(Collectors.toList());
    }

}
