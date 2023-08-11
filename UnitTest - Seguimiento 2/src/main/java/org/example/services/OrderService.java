package org.example.services;

import org.example.domain.models.Client;
import org.example.domain.models.Order;
import org.example.domain.models.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Product> getSizeOrders(List<Order> orders, LocalDate startDate, LocalDate endDate);
    List<Order> getLastOrders(List<Order> orders, LocalDate endDate);
    double totalPrice(List<Order> orders);
    double totalPriceProm(List<Order> orders);
    Map<Client, List<Order>> sortByClient(List<Order> orders);
    Long countOrder(List<Order> orders);

}
