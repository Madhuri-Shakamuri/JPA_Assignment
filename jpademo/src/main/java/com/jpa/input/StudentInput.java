package com.jpa.input;

import com.jpa.entity.Student;
import com.jpa.services.StudentService;

import java.time.LocalDate;
import java.util.Scanner;
public class StudentInput 
{
    
    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
        StudentService service =new StudentService();
        System.out.println("Student Management System : ");
        
  
        while(true)
        {
            System.out.println("1. Add Students ");
            System.out.println("2. Display Student");
            System.out.println("3. Search Student ");
            System.out.println("4. Update  Student ");
            System.out.println("5. Delete Student ");
            System.out.println("6. Exit ");
            System.out.println("Enter your Choice :");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter Name : ");
                    String name=sc.nextLine();
                    System.out.println("Enter Age : ");
                    int age=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Course : ");
                    String course=sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    System.out.println("Enter Phone : ");
                    String phone = sc.nextLine();
    
                  System.out.println("Enter Enrollment Date (YYYY-MM-DD): ");
                  LocalDate enrollmentDate = LocalDate.parse(sc.nextLine());
                    
                    service.addStudent(new Student(name,age,course, email, phone, enrollmentDate));
                    
                    break;

                case 2:  
                     service.displayStudents();
                     break;

                case 3:
                     System.out.println("Enter Student Id to search: ");
                     int search_id=sc.nextInt();
                     service.searchStudent(search_id);
                    break;

                case 4:
                     System.out.println("Provide required data for update:"); 
                     System.out.println("Enter ID : ");
                    int id1=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name : ");
                    String name1=sc.nextLine();
                    System.out.println("Enter Age : ");
                    int age1=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Course : ");
                    String course1=sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email1 = sc.nextLine();
                    System.out.println("Enter Phone : ");
                    String phone1 = sc.nextLine();
                    System.out.println("Enter Enrollment Date (YYYY-MM-DD): ");
                    LocalDate enrollmentDate1 = LocalDate.parse(sc.nextLine());
                    if(service.updateStudent(id1,name1, age1, course1, email1, phone1, enrollmentDate1))
                    System.out.println("Student details are updated");
                    else 
                    System.out.println("Failed to update");
                     break;

                case 5:
                     System.out.println("Enter the id to delete the student details");
                      int id2=sc.nextInt();
                     if(service.deleteStudent(id2))
                     {
                        System.out.println("Student deleted successfully");
                     }
                     else 
                     System.out.println("Student not found");
                     break;
                      
                case 6:
        
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice try again!");
                    break;  

            }
        }
        
    }
}
