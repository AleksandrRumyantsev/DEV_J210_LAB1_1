package com.example.dev_j210_lab1_1.repository;

import com.example.dev_j210_lab1_1.entities.AddressEntity;
import com.example.dev_j210_lab1_1.entities.ClientEntity;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface AppReposI {
    List<ClientEntity> getClients();
    List<ClientEntity> getClients(String s1, String s2);
    List<AddressEntity> getAddress();
    ClientEntity createClient(ClientEntity client);
    AddressEntity createAddress(AddressEntity address);
    <T>List<T> findAll(Class<T> clazz);
    ClientEntity findClientById(int id);

    <T>T findById(Class<T> clazz, int id);
    void close();
    void deleteClient(int clientid, int addressid);
    ClientEntity updateClient(ClientEntity client);
    AddressEntity updateAddress(AddressEntity address);
    void deleteAddress(int id);
    AddressEntity findAddressById(int id);

}
