package com.jpa.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location
 {
    private String name;
    private String address;
    private String city;

   
    public Location() {}
    public Location(String name, String address, String city) 
    {

        this.name = name;
        this.address = address;
        this.city = city;
    }

    public void setInstituteName(String name) {     this.name = name; }
    public void setAddress(String address) {    this.address = address;}
    public void setCity(String city) {    this.city = city;}
    

    public String getInstituteName()  { return name;}
    public String getAddress() {return address; }
    
    public String getCity() {return city; }

    public String toString()
    {
        return "Name: "+name+"Address: "+address+"City : "+city;
    }

}
