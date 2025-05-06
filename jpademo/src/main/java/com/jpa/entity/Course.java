package com.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Courses")
public class Course
{
   @Id
   @GeneratedValue(strategy =GenerationType.IDENTITY)
   @Column(name="cou_id")
   private int id;

   @Column(name="cou_title")
   private String title;
   @Column(name="cou_fee")
   private double fee;

   @Embedded
   private Location location;
   public Course()
   {

   }
   public  Course(String title,double fee)
   {
    this.title=title;
    this.fee=fee;
   }

    public void setTitle(String title) { this.title=title;}
    public void setFee(double fee) { this.fee=fee;}
   
    public int getId(){return id;}
    public String getTitle(){ return title;}
    public double getFee(){ return fee;}

    public String toString()
    {
        return "ID : "+id+" Title : "+title+"fee : "+fee;
    }
    
}
