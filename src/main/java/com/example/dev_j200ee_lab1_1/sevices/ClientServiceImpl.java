package com.example.dev_j200ee_lab1_1.sevices;

import com.example.dev_j200ee_lab1_1.model.Address;
import com.example.dev_j200ee_lab1_1.model.Client;
import com.example.dev_j200ee_lab1_1.sevices.ClientService;
import jakarta.ejb.Stateful;

import java.util.*;
@Stateful
public class ClientServiceImpl implements ClientService {
    private static List<Client> clients;

    static{
        clients = new ArrayList<>();
        Client c1 = new Client(1, "ООО АСТА", "Юридическое лицо", new Date(1985,04,13));
        c1.setAddresses(new Address("127.0.0.1", "45:16:74:32:48:52", "Lenovo", "Ул. Художников, д.24, кв.5", c1));
        c1.setAddresses(new Address("128.1.1.1", "48:16:74:32:48:52", "Dell", "Ул. Науки, д.24, кв.5", c1));
        clients.add(c1);
        Client c2 = new Client(2, "Алиса", "Физическое лицо", new Date(1987,05,15));
        c2.setAddresses(new Address("172.16.255.2","61:98:41:AF:45:DD", "Intel", "Ул. Воронцовский, д.4, кв 78", c2));
        clients.add(c2);
        Client c3 = new Client(3, "Марианна", "Физическое лицо", new Date(2012,12,25));
        c3.setAddresses(new Address("0.0.0.0", "71:58:34:AA:CD:DА", "iMac", "пр. Просвещения, д.50. кв. 37", c3));
        clients.add(c3);
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }
}
