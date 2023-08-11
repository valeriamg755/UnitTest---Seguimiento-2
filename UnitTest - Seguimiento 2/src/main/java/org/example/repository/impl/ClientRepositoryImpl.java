package org.example.repository.impl;

import org.example.domain.enums.ClientType;
import org.example.domain.models.Client;
import org.example.mapping.dtos.ClientDto;
import org.example.mapping.mappers.ClientMapper;
import org.example.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public ClientRepositoryImpl() {

        Client client1 = new Client(51, "Kim Dokja", ClientType.TIER1);
        Client client2 = new Client(49, "Lee Hakhyun", ClientType.TIER2);
        Client client3 = new Client(1863, "Yoo Joonghyuk", ClientType.TIER3);

        clients = new ArrayList<Client>();

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
    }

    @Override
    public List<ClientDto> listAllClient() {
        return ClientMapper.mapFrom(clients);
    }

}
