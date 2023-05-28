package com.example.dev_j200ee_lab1_1.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "test_db", catalog = "")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
    @Column(name = "client_id")
    private Integer clientId;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "clientid")
    private ClientEntity clientByClientId;

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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
