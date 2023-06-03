package com.example.dev_j200ee_lab1_1.repository;

import com.example.dev_j200ee_lab1_1.entities.AddressEntity;
import com.example.dev_j200ee_lab1_1.entities.ClientEntity;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.Metamodel;

import java.util.Collection;
import java.util.List;
@Singleton
public class ReposImpl implements AppReposI{
@PersistenceContext
private EntityManager em;
    @Override
    public List<ClientEntity> getClients() {
        return em.createNativeQuery("SELECT * FROM client", ClientEntity.class).getResultList();
    }
    public List<ClientEntity> getClients(String filterParam, String filterType) {
        if (filterParam == null){filterParam = "";}
        if (filterType == null){filterType = "";}
        String sql = "SELECT clientid, client_name, c_type, added FROM client WHERE client_name LIKE '%" + filterParam+ "%'  AND c_type LIKE '%" + filterType+ "%'";
        //String sql = "SELECT c.clientid, c.client_name, c.c_type, c.added FROM client as c inner join  address as a ON c.clientid=a.clientid WHERE c.client_name LIKE '%" + filterParam+ "%' or  a.address LIKE '%" + filterParam+ "%' AND c_type LIKE '%" + filterType+ "%'";
        Query query = em.createNativeQuery(sql, ClientEntity.class);
        List<ClientEntity> clients = query.getResultList();
        return clients;
    }
    @Override
    public List<AddressEntity> getAddress() {
        return em.createNativeQuery("SELECT * FROM address", AddressEntity.class).getResultList();
    }


    @Override
    public ClientEntity createClient(ClientEntity client) {
        client=em.merge(client);
        em.flush();
        return client;
    }

    @Override
    public AddressEntity createAddress(AddressEntity address) {
        address=em.merge(address);
        em.flush();
        return address;
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Metamodel m = em.getMetamodel();
        Root<T> obj = cq.from(clazz);
        return em.createQuery(cq.select(obj)).getResultList();
    }

    @Override
    public ClientEntity findClientById(int id) {
        return em.find(ClientEntity.class, id);
    }
    @Override
    public AddressEntity findAddressById(int id) {
        return em.find(AddressEntity.class, id);
    }
    @Override
    public <T> T findById(Class<T> clazz, int id) {
        return em.find(clazz, id);
    }

    @Override
    public void close() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }

    @Override
    public void deleteClient(int clientid, int addressid) {
        em.remove(findAddressById(addressid));
        em.flush();
        ClientEntity client = findClientById(clientid);
        Collection<AddressEntity> addresses =  client.getAddressEntityList();
        if (addresses.size() == 1){
            em.remove(findClientById(clientid));
            em.flush();
        }
    }

    @Override
    public ClientEntity updateClient(ClientEntity client) {
        client=em.merge(client);
        em.flush();
        return client;
    }

    @Override
    public AddressEntity updateAddress(AddressEntity address) {
        address=em.merge(address);
        em.flush();
        return address;
    }

    @Override
    public void deleteAddress(int id) {
        em.remove(findAddressById(id));
        em.flush();
    }


}
