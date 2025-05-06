package com.jpa.services;

import com.jpa.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CourseService 
{
     public CourseService() 
     {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("all-units");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
        System.out.println("JPA initialized – check your DB for table creation.");
    }
    
}
