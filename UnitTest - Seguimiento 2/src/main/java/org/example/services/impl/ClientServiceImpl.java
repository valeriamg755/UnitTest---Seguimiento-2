package org.example.services.impl;

import org.example.domain.enums.ClientType;
import org.example.mapping.dtos.ClientDto;
import org.example.repository.ClientRepository;
import org.example.repository.impl.ClientRepositoryImpl;
import org.example.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    List<ClientDto> customers;

    public ClientServiceImpl() {
        ClientRepository repoCustomer = new ClientRepositoryImpl();
        this.customers = repoCustomer.listAllClient();
    }

    public static String processType(ClientType type) {
        System.out.println(Thread.currentThread());
        return String.valueOf(type) + "You have fast delivery";
    }

    public static String processType2(ClientType type) {
        System.out.println(Thread.currentThread());
        return String.valueOf(type) + "You have 10% in all products";
    }

    public static String processType3(ClientType type) {
        System.out.println(Thread.currentThread());
        return String.valueOf(type) + "You have free delivery ";
    }

    public static void launchException() {
        throw new RuntimeException("Exception");
    }

    public List<ClientDto> getAllClients(ClientType tier) {
        return this.customers;
    }

}
