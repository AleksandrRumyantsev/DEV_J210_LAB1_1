package com.example.dev_j200ee_lab1_1.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "client", schema = "test_db", catalog = "")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "clientid")
    private int clientid;
    @Basic
    @Column(name = "client_name")
    private String clientName;
    @Basic
    @Column(name = "c_type")
    private String cType;
    @Basic
    @Column(name = "added")
    private Timestamp added;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<AddressEntity> addressEntityList = new ArrayList<>();

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return clientid == that.clientid && Objects.equals(clientName, that.clientName) && Objects.equals(cType, that.cType) && Objects.equals(added, that.added);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientid, clientName, cType, added);
    }

    public List<AddressEntity> getAddressEntityList() {
        return addressEntityList;
    }

    public void setAddressEntityList(List<AddressEntity> addressEntityList) {
        this.addressEntityList = addressEntityList;
    }
}
