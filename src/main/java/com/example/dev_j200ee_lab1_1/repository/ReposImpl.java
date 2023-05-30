package com.example.dev_j200ee_lab1_1.repository;

import com.example.dev_j200ee_lab1_1.entities.AddressEntity;
import com.example.dev_j200ee_lab1_1.entities.ClientEntity;
import com.example.dev_j200ee_lab1_1.model.Address;
import com.example.dev_j200ee_lab1_1.model.Client;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
@Singleton
public class ReposImpl implements AppReposI{
@PersistenceContext
private EntityManager em;
    @Override
    public List<ClientEntity> getClients() {
    String sql = "SELECT * FROM CLIENT";
    Query query = em.createNativeQuery(sql);
    List<ClientEntity> clients = query.getResultList();
    return clients;
    }

//    @Override
//    public void createClient(Client client, Address address) {
//        String sql = "INSERT INTO test_db.client \n" +
//                "(client_name,c_type)\n" +
//                "values\n" +
//                "('"+ client.getClient_name() + "','" + client.getType() +"');\n"+
//                "insert into test_db.address\n"+
//                "(ip, mac, model, address, client_id)\n"+
//                "values\n"+
//                "('"+ address.getIp() + "','" + address.getMac()+"','"+ address.getModel()+"','"+address.getAddress()+"','"+address.getClient()+"');";
//        Query query = em.createNativeQuery(sql);
//
////                client = em.merge(client);
//////        return client;
//    }

    @Override
    public Client createClient(Client client) {
        client = em.merge(client);
        return client;
    }

    @Override
    public AddressEntity createAddress(AddressEntity address) {
        return null;
    }
}
