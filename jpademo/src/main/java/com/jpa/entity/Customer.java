package com.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer 
{
    @Id
    @Column(name = "cust_email")
    private String email;

    @Column(name = "cust_name")
    private String name;
    @Column(name = "cust_phone_num")
    private String phone_num;

    public Customer()
    {

    }
    public Customer(String email,String name,String phone_num)
    {
        this.email=email;
        this.name=name;
        this.phone_num=phone_num;
    }
    public void setEmail(String email) { this.email=email;}
    public void setName(String name) { this.name=name;}
    public void setPhone(String phone_num) { this.phone_num=phone_num;}



    public String getEmail(){ return email;}
    public String getName(){ return name;}
    public String getPhone(){ return phone_num;}

    public String toString()
    {
        return "Email : "+email+" Name : "+name+"Phone_Num : "+phone_num;
    }
}
