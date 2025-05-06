package com.jpa.services;

import com.jpa.entity.Customer;

import jakarta.persistence.*;
import java.util.List;
public class CustomerService 
{
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
    

    public void addCustomer(Customer c)
    {
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try
        {
        
        et.begin();
        em.persist(c);

        System.err.println("Added Successfully");
        et.commit();
        }
        catch(Exception e)
        {
            et.rollback();
            System.out.println("Failed to add");
            e.printStackTrace();

        }
        finally
        {
            em.close();
            
        }

    }
    public void displayCustomer()
    {
        EntityManager em=emf.createEntityManager();
        
        try
        {

          List<Customer> customers=em.createQuery("SELECT c FROM Customer c",Customer.class).getResultList();
            
          if(customers.isEmpty())
          {
            System.out.println("No customers details here");
          }
          else 
          {
            for(Customer c:customers)
            {
                System.out.println(c);
            }
            System.out.println("Displayed Successfully!");
          }
        }
        catch(Exception e)
        {
            System.out.println("Failed to Display");
            e.printStackTrace();
            
        }
    }
    public  void search_Customer(String email)
    {

        EntityManager em=emf.createEntityManager();
        try
        {
            List<Customer> customers=em.createQuery("SELECT c FROM Customer c WHERE email=:email",Customer.class).
                                                    setParameter("email",email).getResultList();
            if(customers.isEmpty())
            {
                System.out.println("NO customer is available");
            }
            else 
            {
                for(Customer c:customers)
                {
                    System.out.println(c);
                }
                System.out.println("Successfullt Done!");
            }


        }
        catch(Exception e)
        {
            System.out.println("Failed to Search");
            e.printStackTrace();
        }
        finally
        {
            em.close();
           
        }

        
    }
    public void updateCustomer(String email,String name,String phone_num)
    {
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try 
        {
         et.begin();
         Query q=em.createQuery("UPDATE  Customer c SET c.name=:name,c.phone_num=:phone_num WHERE c.email=:email")
                                      .setParameter("name",name)
                                      .setParameter("phone_num",phone_num)
                                      .setParameter("email",email);
         int updated=q.executeUpdate();
        if(updated>0)
        System.out.println("Updated Successfully!");
        else 
        {
            System.out.println("Failed to update");
        }
        et.commit();

        }
        catch(Exception e)
        {
            et.rollback();
            System.out.println("Failed To update");
            e.printStackTrace();
        }
        finally
        {
            em.close();
        }
    }
    public void deleteCustomer(String email)
    {
         EntityManager em=emf.createEntityManager();
         EntityTransaction et=em.getTransaction();
         try 
         {
            et.begin();
            Query q=em.createQuery("DELETE FROM Customer c WHERE c.email=:email ").setParameter("email", email);

            int  deleted=q.executeUpdate();
            if(deleted>0)
        System.out.println("Deleted Successfully!");
        else 
        {
            System.out.println("Failed to update");
        }
        et.commit();
         }
         catch(Exception e)
         {
            
            e.printStackTrace();
         }
         finally
         {
            em.close();
            
         }
        
    }
    

    
    
}
    
