package com.example.dev_j200ee_lab1_1.model;

import java.util.Objects;

public class Address {
    private int id;
    private String mac;
    private String model;
    private String address;
    private Client client;

    public Address(int id, String mac, String model, String address, Client client) {

        this.id = id;
        this.mac = mac;
        this.model = model;
        this.address = address;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return id == address1.id && Objects.equals(mac, address1.mac) && Objects.equals(model, address1.model) && Objects.equals(address, address1.address) && Objects.equals(client, address1.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mac, model, address, client);
    }
}
