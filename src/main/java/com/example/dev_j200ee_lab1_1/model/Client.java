package com.example.dev_j200ee_lab1_1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Client {
    private int clientid;
    private String client_name;
    private String type;
    private Date added;
    private List<Address> addresses;

    public Client(int clientid,String client_name, String type, Date added) {
        this.clientid = clientid;
        this.client_name = client_name;
        this.type = type;
        this.added = added;
        addresses = new ArrayList<>();
        //this.addresses = addresses;
    }
    public Client( String client_name, String type) {
        //this.clientid = clientid;
        this.client_name = client_name;
        this.type = type;
        //this.added = added;
        addresses = new ArrayList<>();
        //this.addresses = addresses;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address address) {
        addresses.add(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientid == client.clientid && Objects.equals(client_name, client.client_name) && Objects.equals(type, client.type) && Objects.equals(added, client.added) && Objects.equals(addresses, client.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientid, client_name);
    }
}
