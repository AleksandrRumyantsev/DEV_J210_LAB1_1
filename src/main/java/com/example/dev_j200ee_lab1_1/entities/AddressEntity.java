package com.example.dev_j200ee_lab1_1.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
//@Table(name = "address")
@Table(name = "address", schema = "test_db", catalog = "")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @Column(name = "addressid")
    private int addressid;
    @Basic
    @Column(name = "ip")
    private String ip;
    @Basic
    @Column(name = "mac")
    private String mac;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "clientid")
    private Integer clientId;
    @Basic(optional = false)
    //@JoinColumn(insertable = false, updatable = false, name = "client_id",referencedColumnName = "clientid")
    @JoinColumn(insertable = false, updatable = false,name = "clientid",nullable = false)
    //@JoinColumn(name = "client_id")
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    //@ManyToOne(fetch = FetchType.LAZY)
    private ClientEntity client;

    public AddressEntity(){}
    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
        clientId = client.getClientid();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return addressid == that.addressid && Objects.equals(ip, that.ip) && Objects.equals(mac, that.mac) && Objects.equals(model, that.model) && Objects.equals(address, that.address) && Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressid, ip, mac, model, address, clientId);
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "addressid=" + addressid +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", model='" + model + '\'' +
                ", address='" + address + '\'' +
                ", clientId=" + clientId +
                ", client=" + client +
                '}';
    }
}
