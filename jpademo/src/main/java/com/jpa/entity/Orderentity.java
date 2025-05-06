package com.jpa.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orderentity 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private  String cust_name;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderProduct> orderproduct=new ArrayList<>();


    public Orderentity(){}
    public Orderentity(LocalDate date, String cust_name) {
        this.date = date;
        this.cust_name = cust_name;
    }


    
    public int getId() {
        return id;
    }
    
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getCust_name() {
        return cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public List<OrderProduct> getOrderproduct() {
        return orderproduct;
    }
    public void setOrderproduct(List<OrderProduct> orderproduct) {
        this.orderproduct = orderproduct;
    }
    
    
}
