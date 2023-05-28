package com.example.dev_j200ee_lab1_1.sevices;

import com.example.dev_j200ee_lab1_1.model.Client;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface ClientService {
    List<Client> getAllClients();
}
