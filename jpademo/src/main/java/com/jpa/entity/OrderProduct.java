package com.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderProduct 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Orderentity orders;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Productquestion_9 product;
    
    public OrderProduct(int quantity, Orderentity orders, Productquestion_9 product) {
        this.quantity = quantity;
        this.orders = orders;
        this.product = product;
    }
    public OrderProduct(){}
    public OrderProduct(int quantity) {
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Orderentity getOrder() {
        return orders;
    }
    public void setOrder(Orderentity orders) {
        this.orders = orders;
    }
    public Productquestion_9 getProduct() {
        return product;
    }
    public void setProduct(Productquestion_9 product) {
        this.product = product;
    }
    

    


    
}
