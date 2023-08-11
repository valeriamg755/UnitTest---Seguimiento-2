package org.example.services;

import org.example.domain.enums.ClientType;
import org.example.mapping.dtos.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAllClients(ClientType var1);

}
