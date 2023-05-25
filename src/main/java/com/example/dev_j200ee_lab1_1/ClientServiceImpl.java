package com.example.dev_j200ee_lab1_1;

import com.example.dev_j200ee_lab1_1.model.Address;
import com.example.dev_j200ee_lab1_1.model.Client;
import com.example.dev_j200ee_lab1_1.sevices.ClientService;

import java.util.*;

public class ClientServiceImpl implements ClientService {
    private static List<Client> clients;

    static{
        clients = new ArrayList<>();
        Client c1 = new Client(1, "Sasha", "Юридическое лицо", new Date(1985,04,13));
        c1.setAddresses(new Address(1,"127.0.0.1", "45:16:74:32:48:52", "Ул. Пушкина, д.31, кв.5", c1));
        clients.add(c1);
        Client c2 = new Client(2, "Alisa", "Физическое лицо", new Date(1987,05,15));
        c2.setAddresses(new Address(2,"172.16.255.2","61:98:41:AF:45:DD","Ул. Коретная, д.3, кв 78", c2));
        clients.add(c2);
        Client c3 = new Client(3, "Marianna", "Физическое лицо", new Date(2012,12,25));
        c3.setAddresses(new Address(3,"0.0.0.0", "71:58:34:AA:CD:DА", "пр. Мира, д.80. кв. 37", c3));
        clients.add(c3);
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }
}
