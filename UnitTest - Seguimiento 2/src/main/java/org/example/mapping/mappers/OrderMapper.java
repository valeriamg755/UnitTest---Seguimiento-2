package org.example.mapping.mappers;

import org.example.domain.models.Order;
import org.example.mapping.dtos.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDto mapFrom(Order source){
        return new OrderDto(source.getId(),
                source.getStatus(),
                source.getOrderDate(),
                source.getDeliveryDate()
        );
    }
    public static Order mapFrom(OrderDto source){
        return new Order(source.id(),
                source.status(),
                source.orderDate(),
                source.deliveryDate(),
                source.product(),
                source.client());
    }
    public static List<OrderDto> mapFrom(List<Order> source) {
        return source.stream().map(OrderMapper::mapFrom).collect(Collectors.toList());
    }

}
