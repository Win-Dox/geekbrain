package com.example.meal.client.reposiroty;

import com.example.meal.client.model.Client;

import java.util.List;

public interface IClientRepository {
    Client save(Client client);

    Client update(Client client);

    void delete (Client client);

    Client getById(Integer id);

    List<Client> getAll();
    List<Client> getAll(Integer count);
    List<Client> getAll(Integer count, Integer after);
}
