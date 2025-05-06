package com.jpa.input;

import java.time.LocalDate;
import java.util.Scanner;

import com.jpa.entity.Orderentity;
import com.jpa.entity.OrderProduct;
import com.jpa.entity.Productquestion_9;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OrderProductInput_8 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try(Scanner sc=new Scanner(System.in);)
        {
         et.begin();
         System.out.println("Enter Order Details: ");
         System.out.println("Enter Date in YYYY-MM-DD format: ");
         LocalDate o_date=LocalDate.parse(sc.nextLine());
         System.out.println("Enter Customer Name: ");
         String o_name=sc.nextLine();
         Orderentity orders=new Orderentity(o_date,o_name);

         System.out.println("Enter Product Details: ");
         System.out.println("Enter product Name: ");
         String p_name=sc.nextLine();
         System.out.println("Enter product Price: ");
         double p_price=sc.nextDouble();        
         Productquestion_9 prod=new Productquestion_9(p_name,p_price);

         System.out.println("Enter OrderProduct Details: ");
         System.out.println("Enter quantity: ");
         int op_quantity=sc.nextInt();

         OrderProduct op=new OrderProduct(op_quantity,orders,prod);

        // Need to establish connection
        orders.getOrderproduct().add(op);
        

         em.persist(orders);
         em.persist(prod);
         em.persist(op);
         System.out.println("Succesfully done!");
         et.commit();

        }
        catch(Exception e)
        {
           et.rollback();
           System.out.println("Failed");  
           e.printStackTrace();
        }
        
    }
    
}
