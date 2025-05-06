package com.jpa.services;

import com.jpa.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductService 
{
     EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
     

     public void addProduct(Product p1,Product p2)
     { 
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
     try 
     {
        
        et.begin();
        em.persist(p1);
        em.persist(p2);
        et.commit();
        System.out.println("Two products Added Successfully");
     }
     catch(Exception e)
     {
       et.rollback();
       System.out.println("Failed to add product");
     }
     finally 
     {
        em.close();
     }
    }
      

}
