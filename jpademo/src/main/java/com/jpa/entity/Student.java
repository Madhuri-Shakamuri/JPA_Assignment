package com.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student 
{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private int age;
    private String course;
    private String email;
    private String phone;
    private LocalDate enrollmentDate;


    public Student() // hibernate need an 0 constructor
    {

    }
    public Student(String name,int age,String course,String email,String phone,LocalDate enrollmentDate)
    {
      this.name=name;
      this.age=age;
      this.course=course;
      this.email=email;
      this.phone=phone;
      this.enrollmentDate=enrollmentDate;
    }

    public void setName(String name){ this.name=name ; }
    public void setAge(int age){ this.age=age; }
    public void setCourse(String course){ this.course=course; }
    public void setEmail(String email) { this.email=email; }
    public void setPhone(String phone) { this.phone=phone; }
    public void setEnrollmentDate(LocalDate enrollmentDate){ this.enrollmentDate=enrollmentDate; }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public LocalDate getEnrollmentDate(){return enrollmentDate; }


    public String toString()
    {
        return "ID : "+getId()+
        "\nName : "+getName()+
        "\nAge : "+getAge()+
        "\nCourse : "+getCourse()+
        "\n Email : "+getEmail()+
        "\nPhone Number : "+getPhone()+
        "\nEnrollement Date : "+getEnrollmentDate();
    }
}
