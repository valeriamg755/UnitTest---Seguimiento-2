package org.example.repository.impl;

import org.example.domain.enums.OrderType;
import org.example.domain.models.Client;
import org.example.domain.models.Order;
import org.example.domain.models.Product;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.mappers.ClientMapper;
import org.example.mapping.mappers.OrderMapper;
import org.example.mapping.mappers.ProductMapper;
import org.example.repository.ClientRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    List<Product> products;
    List<Product> productsA;
    List<Product> productsB;
    List<Client> clients;
    public OrderRepositoryImpl() {

        ClientRepository clientRepository = new ClientRepositoryImpl();
        ProductRepository productRepository = new ProductRepositoryImpl();
        productsA = ProductMapper.mapFromDto(productRepository.listAllProductsA());
        productsB = ProductMapper.mapFromDto(productRepository.listAllProductsB());

        clients = ClientMapper.mapFromDto(clientRepository.listAllClient());


        Order order1 = new Order(1L,
                OrderType.ONGOING,
                LocalDate.of(2023, 02, 20),
                LocalDate.of(2023, 03, 24),
                productsA,
                clients.get(0));
        Order order2 = new Order(2L,
                OrderType.CANCELLED,
                LocalDate.of(2023, 01, 10),
                LocalDate.of(2023, 01, 14),
                productsB,
                clients.get(1));
        Order order3 = new Order(3L,
                OrderType.COMPLETED,
                LocalDate.of(2023, 01, 10),
                LocalDate.of(2023, 01, 14),
                productsB,
                clients.get(0));

        orders = new ArrayList<Order>();

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }

    @Override
    public List<OrderDto> listAllOrder() {
        return OrderMapper.mapFrom(orders);
    }
}