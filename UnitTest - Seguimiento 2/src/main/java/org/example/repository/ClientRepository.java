package org.example.repository;

import org.example.mapping.dtos.ClientDto;

import java.util.List;

public interface ClientRepository {

    List<ClientDto> listAllClient();

}
