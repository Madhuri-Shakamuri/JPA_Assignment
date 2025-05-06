package com.jpa.services;

import java.time.LocalDate;
import java.util.List;

import com.jpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentService
{
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("all-units");
    public void addStudent(Student s) 
    {
    EntityManager em=emf.createEntityManager();
   
    try
    {
      em.getTransaction().begin();
      em.persist(s);
      System.out.println("Student Added SSuccessfully!");
      em.getTransaction().commit();
    }
    catch(Exception e)
    {
        em.getTransaction().rollback();
        System.out.println("Falied to add student");
        e.printStackTrace();
        
    }
    finally 
    {
        em.close();
    }
    }

    public void displayStudents()
    {
        EntityManager em=emf.createEntityManager();
        
    try
    {
     
        List<Student> students=em.createQuery("SELECT s FROM Student s",Student.class).getResultList();
      if(students.isEmpty())
      {
        System.out.println("No student details are available");

      }
      else 
      {
        for (Student s : students) 
        {
            System.out.println(s); 
        }
 
        System.out.println("Student Detaills are displayed Successfully!");
  
      }
     
    }
    catch(Exception e)
    {
        
        System.out.println("Falied to display");
        e.printStackTrace();

    }
    finally {
        em.close();
    }
    }
    public void searchStudent(int id)
    {
      EntityManager em=emf.createEntityManager();

      try
      {
        List<Student> students=em.createQuery("SELECT s FROM Student s WHERE s.id=:id",Student.class).setParameter("id",id).getResultList();
        if(students.isEmpty())
        {
            System.out.println("No student is available with this id");
        }
        else 
        {
            for(Student s:students)
            {
                System.out.println(s);
            }
            System.out.println("Here are the details of the student with this id:");

        }

      }
      catch(Exception e)
      {
        System.out.println("");
        e.printStackTrace();
      }
     return ;
    }
    public boolean updateStudent(int id, String name, int age, String course, String email, String phone, LocalDate enrollmentDate)
{
    EntityManager em = emf.createEntityManager();
    try
    {
        em.getTransaction().begin();
        int updateCount = em.createQuery("UPDATE Student s SET s.name=:name, s.age=:age, s.course=:course, s.email=:email, s.phone=:phone, s.enrollmentDate=:enrollmentDate WHERE s.id=:id")
                             .setParameter("name", name)
                             .setParameter("age", age)
                             .setParameter("course", course)
                             .setParameter("email", email)
                             .setParameter("phone", phone)
                             .setParameter("enrollmentDate", enrollmentDate)
                             .setParameter("id", id)
                             .executeUpdate();
        em.getTransaction().commit();

        return updateCount > 0;
    }
    catch(Exception e)
    {
        em.getTransaction().rollback();
        e.printStackTrace();
    }
    finally
    {
        em.close();
    }
    return false;
}

    public boolean deleteStudent(int id)
    {
        EntityManager em=emf.createEntityManager();
        try 
        {
          em.getTransaction().begin();
          Query q=em.createQuery("DELETE FROM Student s WHERE id=:id").setParameter("id", id);
          int deleted=q.executeUpdate();
          if(deleted>0)
          return true;
          em.getTransaction().commit();
         
          
        }
        catch(Exception e)
        {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    return false;

    }
    

}
