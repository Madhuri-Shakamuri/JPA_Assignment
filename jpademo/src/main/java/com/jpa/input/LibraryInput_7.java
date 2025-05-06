package com.jpa.input;

import java.time.LocalDate;
import java.util.Scanner;

import com.jpa.entity.Employee;
import com.jpa.entity.LibraryMembership;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LibraryInput_7 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        

        try(Scanner sc=new Scanner(System.in);) 
        {
            et.begin();
            System.out.println("Enter Employee Details: ");
            System.out.println("Enter emp name: ");
            String e_name=sc.nextLine();
            Employee emp=new Employee(e_name);

            System.out.println("Enter Library Details: ");
            System.out.println("Enter membership type: ");
            String l_mem_type=sc.nextLine();
            System.out.println("Enter start date: ");
            LocalDate l_date=LocalDate.parse(sc.nextLine());
            LibraryMembership  lib_mem=new LibraryMembership(l_mem_type,l_date,emp);
           emp.setLib_mem(lib_mem);
            
            em.persist(emp);
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
