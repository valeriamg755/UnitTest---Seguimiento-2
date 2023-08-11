package org.example.repository;

import org.example.mapping.dtos.OrderDto;

import java.util.List;

public interface OrderRepository {

    List<OrderDto> listAllOrder();

}
