// package com.jpa.services;

// import  com.jpa.entity.Publisher;
// import com.jpa.entity.Titles;

// import jakarta.persistence.EntityManager;

// import java.util.Scanner;

// public class Service 
// {
  
//     public void pubservice(EntityManager em)
//     {

//         try( Scanner sc=new Scanner(System.in);) 
//         {
//          System.out.println("Enter Product Details :");
//          System.out.println("Enter Product Name :");
//          String p_name=sc.nextLine();
//          Publisher p=new Publisher();
//          p.setName(p_name);
//          em.persist(p);
  
//         }
//         catch(Exception e)
//         {
//         e.printStackTrace();
//         }
//     }

//     public void titlesService(EntityManager em)
//     {

//         try( Scanner sc=new Scanner(System.in);) 
//         {
//          System.out.println("Enter Titles Details :");
//          System.out.println("Enter Titles Name :");
//          String t_name=sc.nextLine();
//          Titles t=new Titles();
//          t.setName(t_name);
//          em.persist(t);
//         }
//         catch(Exception e)
//         {
//         e.printStackTrace();
//         }
//     }
    
    
// }
