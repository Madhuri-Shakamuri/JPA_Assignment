package com.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private  String name;
    
    public Employee() 
    {
    }
    public Employee(String name) {
        this.name = name;
    }
    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private LibraryMembership lib_mem;
   
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public LibraryMembership getLib_mem() {
        return lib_mem;
    }
    public void setLib_mem(LibraryMembership lib_mem) {
        this.lib_mem = lib_mem;
    }
   

}
