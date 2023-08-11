package org.example;

import org.example.domain.enums.ClientType;
import org.example.domain.models.Client;
import org.example.domain.models.Order;
import org.example.domain.models.Product;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.example.services.impl.ClientServiceImpl.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 15) {
            System.out.println("Menu");
            System.out.println("1. Filtered products: Books with price > 100,000");
            System.out.println("2. Filtered orders: Products belonging to category 'MOVIE'");
            System.out.println("3. Filtered products: Category 'ELECTRONICS' with 10% discount");
            System.out.println("4. Cheapest products from category 'BOOK'");
            System.out.println("5. Orders from tier 2 customers between February 1, 2021, and April 1, 2021");
            System.out.println("6. The 3 most recent orders");
            System.out.println("7. Total global sum of all orders made on a specific date");
            System.out.println("8. Average payment of orders made on a specific date");
            System.out.println("9. Produce a map of data with order records grouped by customer");
            System.out.println("10. Most expensive product for each category");
            System.out.println("11. Exit");
            System.out.print("Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Filtered products: Books with price > 100,000");
                    getFilteredProductsBooks(products);
                    break;

                case 2:
                    System.out.println("Filtered orders: Products belonging to category 'MOVIE'");
                    getFilteredOrdersByCategory(orders, "MOVIE");
                    break;

                case 3:
                    System.out.println("Filtered products: Category 'ELECTRONICS' with 10% discount");
                    getDiscountedProducts(products);
                    break;

                case 4:
                    System.out.println("Cheapest products from category 'BOOK'");
                    getCheapestProductsByCategory(products, "BOOK");
                    break;

                case 5:
                    System.out.println("Orders from tier 2 customers between February 1, 2021, and April 1, 2021");
                    getOrdersByClientTierAndDate(orders, 2, LocalDate.of(2021, 2, 1),
                            LocalDate.of(2021, 4, 1));
                    break;

                case 6:
                    System.out.println("The 3 most recent orders");
                    getRecentOrders(orders, 3);
                    break;

                case 7:
                    LocalDate dateToCalculateTotalRevenue = LocalDate.of(2022, 3, 1);
                    System.out.println("Total revenue on " + dateToCalculateTotalRevenue + ": " +
                            getTotalRevenueByDate(orders, dateToCalculateTotalRevenue));
                    break;

                case 8:
                    LocalDate dateToCalculateAveragePayment = LocalDate.of(2022, 3, 12);
                    System.out.println("Average payment on " + dateToCalculateAveragePayment + ": " +
                            getAveragePaymentByDate(orders, dateToCalculateAveragePayment));
                    break;

                case 9:
                    System.out.println("Map of data with order records grouped by customer:");
                    produceMapDataByCustomer(orders);
                    break;

                case 10:
                    System.out.println("Most expensive product for each category:");
                    getMostExpensiveProductsByCategory(products);
                    break;

                case 11:
                    System.out.println("\nUse of runAsync");
                    CompletableFuture.runAsync(() -> {
                        ProductServiceImpl.longProcess();
                    });
                    ProductServiceImpl.sleepThread(7000);

                case 12:
                    System.out.println("\nUse of SupplyAsync, thenAccept, thenApply, exceptionally and thenRun ");
                    System.out.println(Thread.currentThread());
                    CompletableFuture var10000 = CompletableFuture.supplyAsync(() -> {
                        return processType(ClientType.LEVEL3);
                    }).thenApply((type) -> {
                        return processType2(type);
                    }).exceptionally((error) -> {
                        System.err.println("Exception " + error.getMessage());
                        return "Variable Error";
                    }).thenApply((type) -> {
                        return processType3(type);
                    });
                    PrintStream var10001 = System.out;
                    Objects.requireNonNull(var10001);
                    var10000.thenAccept(var10001::println).thenRun(Main::launchException);

                case 13:
                    System.out.println("Thank you, goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }

    //------------------------------------------------------------------------------------------------------------------

    private static List<Product> getFilteredProductsBooks(List<Product> products) {
        String category = "BOOK";
        double minPrice = 100000;

        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equals(category) && product.getPrice() > minPrice)
                .collect(Collectors.toList());

        for (Product product : filteredProducts) {
            System.out.println(product);
        }

        return filteredProducts;
    }

    private static List<Order> getFilteredOrdersByCategory(List<Order> orders, String category) {
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals(category)))
                .collect(Collectors.toList());

        for (Order order : filteredOrders) {
            System.out.println(order);
        }

        return filteredOrders;
    }

    private static List<Product> getDiscountedProducts(List<Product> products) {
        String category = "ELECTRONICS";
        double discountPercentage = 0.10;

        List<Product> discountedProducts = products.stream()
                .filter(product -> product.getCategory().equals(category))
                .peek(product -> product.setPrice(product.getPrice() * (1 - discountPercentage)))
                .collect(Collectors.toList());

        for (Product product : discountedProducts) {
            System.out.println(product);
        }

        return discountedProducts;
    }

    private static List<Product> getCheapestProductsByCategory(List<Product> products, String category) {
        List<Product> cheapestProducts = products.stream()
                .filter(product -> product.getCategory().equals(category))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        for (Product product : cheapestProducts) {
            System.out.println(product);
        }

        return cheapestProducts;
    }

    private static List<Order> getOrdersByClientTierAndDate(List<Order> orders, int tier, LocalDate startDate,
                                                            LocalDate endDate) {
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getClient().getTier() == tier)
                .filter(order -> order.getOrderDate().isAfter(startDate) &&
                        order.getOrderDate().isBefore(endDate.plusDays(1))).collect(Collectors.toList());

        for (Order order : filteredOrders) {
            System.out.println(order);
        }

        return filteredOrders;
    }

    private static List<Order> getRecentOrders(List<Order> orders, int count) {
        List<Order> recentOrders = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(count)
                .collect(Collectors.toList());

        for (Order order : recentOrders) {
            System.out.println(order);
        }

        return recentOrders;
    }

    private static double getTotalRevenueByDate(List<Order> orders, LocalDate date) {
        double totalRevenue = orders.stream()
                .filter(order -> order.getOrderDate().equals(date))
                .flatMapToDouble(order -> order.getProducts().stream().mapToDouble(Product::getPrice))
                .sum();

        return totalRevenue;
    }

    private static double getAveragePaymentByDate(List<Order> orders, LocalDate date) {
        OptionalDouble averagePayment = orders.stream()
                .filter(order -> order.getOrderDate().equals(date))
                .flatMapToDouble(order -> order.getProducts().stream().mapToDouble(Product::getPrice))
                .average();

        return averagePayment.orElse(0.0);
    }

    private static void produceMapDataByCustomer(List<Order> orders) {
        Map<Client, List<Order>> mapDataByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getClient));

        mapDataByCustomer.forEach((customer, customerOrders) -> {
            System.out.println("Customer: " + customer.getName());
            for (Order order : customerOrders) {
                System.out.println(order);
            }
            System.out.println("--------------------------");
        });
    }

    private static Map<String, Product> getMostExpensiveProductsByCategory(List<Product> products) {
        Map<String, Product> mostExpensiveProducts = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,
                        Function.identity(),
                        (existing, replacement) -> existing.getPrice() > replacement.getPrice() ? existing : replacement
                ));

        mostExpensiveProducts.forEach((category, product) -> {
            System.out.println("Category: " + category);
            System.out.println("Most expensive product: " + product);
            System.out.println("--------------------------");
        });

        return mostExpensiveProducts;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static String processType(ClientType type) {
        System.out.println(Thread.currentThread());
        return String.valueOf(type) + " -You have fast delivery";
    }

    public static String processType2(String type) {
        System.out.println(Thread.currentThread());
        return type + " -You have 10% in all products";
    }

    public static String processType3(String type) {
        System.out.println(Thread.currentThread());
        return type + " -You have free delivery ";
    }

    public static void launchException() {
        throw new RuntimeException("Exception");
    }

}