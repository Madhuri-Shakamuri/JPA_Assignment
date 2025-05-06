package com.jpa.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Product_table_2")
public class Productquestion_9
{
    @Id
    @Column(name = "prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_price")
    private double price;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderProduct> orderpro=new ArrayList<>();
    public Productquestion_9()
    {

    }
    public Productquestion_9(String name,double price)
    {
        this.name=name;
        this.price=price;

    }
    public void setId(int id) { this.id=id;}
    public void setName(String name){ this.name=name;}
    public void setPrice(double price){this.price=price;}

    public int getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}

    public String toString()
    {
        return "Id: "+getId()+"\tName :"+getName()+"Price: "+getPrice();
    }

    public List<OrderProduct> getOrderpro() {
        return orderpro;
    }

    public void setOrderpro(List<OrderProduct> orderpro) {
        this.orderpro = orderpro;
    }

    
}

    

