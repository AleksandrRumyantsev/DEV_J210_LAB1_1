package com.example.dev_j200ee_lab1_1.repository;

import com.example.dev_j200ee_lab1_1.entities.AddressEntity;
import com.example.dev_j200ee_lab1_1.entities.ClientEntity;
import com.example.dev_j200ee_lab1_1.model.Address;
import com.example.dev_j200ee_lab1_1.model.Client;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface AppReposI {
    List<ClientEntity> getClients();
    ClientEntity createClient(Client client, Address address);
    AddressEntity createAddress(AddressEntity address);
}
