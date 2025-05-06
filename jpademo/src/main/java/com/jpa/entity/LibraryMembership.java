package com.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class LibraryMembership 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    
   private String memebership_type;
   private LocalDate start_date;

   @OneToOne
   @JoinColumn(name="emp_id")
   private Employee employee;

   public LibraryMembership() {}
   public LibraryMembership(String memebership_type, LocalDate start_date) 
   {
        this.memebership_type = memebership_type;
        this.start_date = start_date;
   }
   public LibraryMembership(String memebership_type, LocalDate start_date,Employee employee) 
   {
        this.memebership_type = memebership_type;
        this.start_date = start_date;
        this.employee=employee;
   }


   public Employee getEmployee() 
   {
    return employee;
   }
    public void setEmployee(Employee employee) 
    {    
    this.employee = employee;
    }
   public int getId() 
   {
    return id;
   }
   
   public String getMemebership_type() 
   {
    return memebership_type;
   }
   public void setMemebership_type(String memebership_type)
    {
    this.memebership_type = memebership_type;
   }
   public LocalDate getStart_date() 
   {
    return start_date;
   }
   public void setStart_date(LocalDate start_date) 
   {
    this.start_date = start_date;
   } 
}
