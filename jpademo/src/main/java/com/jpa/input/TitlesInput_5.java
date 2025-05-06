package com.jpa.input;

import java.util.Scanner;
import com.jpa.entity.Publisher;
import com.jpa.entity.Titles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class TitlesInput_5 
{
    public static void main(String[] args)
    {
        
        Scanner sc=new Scanner(System.in);
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
    EntityManager em=emf.createEntityManager();
    EntityTransaction et=em.getTransaction();
    try
    {
        
        et.begin();
        System.out.println("Enter Publisher Details:");
        String p_name=sc.nextLine();
        Publisher p=new Publisher(p_name);
        System.out.println("Enter Title details: ");
        String t_name=sc.nextLine();
        Titles t=new Titles(t_name,p);
        p.getTitles().add(t);  // this line helps the titles to know about publisher - bidirectional commmunication
        em.persist(p);

        
        et.commit();
    }
    catch(Exception e)
    {
        et.rollback();
        e.printStackTrace();
    }
    finally
    {
        em.close();
        emf.close();
    }
  
   
        
    }
}
//{ }  instance block we can use static block tooo because java does  not allow executable stmts like try-catch,et.begin etc in class body it must be static or instance

