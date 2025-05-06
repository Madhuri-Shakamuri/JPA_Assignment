package com.jpa.input;

import java.util.Scanner;

import com.jpa.entity.Product;
import com.jpa.entity.Sales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SalesInput_6 
{
    
    public static void main(String[] args) 
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try(Scanner sc=new Scanner(System.in);) 
        {
         et.begin();
         System.out.println("Enter product Details: ");
         System.out.println("Enter product name:");
         String p_name=sc.nextLine();
         System.out.println("Enter price: ");
         double p_price=sc.nextDouble();
         sc.nextLine();
         Product p=new Product(p_name,p_price);
         System.out.println("Enter Sales Details: ");
         System.out.println("Enter  quantity:");
         int s_quantity=sc.nextInt();
         Sales s=new Sales(s_quantity, p);

        p.getSales().add(s);
         em.persist(p);
         et.commit();

        }
        catch(Exception e)
        {
            et.rollback();
            System.out.println("Falied");
            e.printStackTrace();
        }
        finally 
        {
            em.close();
        }
        
    }
}
