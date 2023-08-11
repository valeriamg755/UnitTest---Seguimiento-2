package org.example.mapping.mappers;

import org.example.domain.models.Client;
import org.example.mapping.dtos.ClientDto;

import java.util.List;

public class ClientMapper {

    public static ClientDto mapFrom(Client source){
        return new ClientDto(source.getId(), source.getName(),source.getTier());
    }
    public static Client mapFrom(ClientDto source){
        return new Client(source.id(),source.name(),source.tier());
    }
    public static List<ClientDto> mapFrom(List<Client> source){
        return source.stream().
                map(ClientMapper::mapFrom)
                .toList();
    }public static List<Client> mapFromDto(List<ClientDto> source){
        return source.stream().
                map(ClientMapper::mapFrom)
                .toList();
    }

}
