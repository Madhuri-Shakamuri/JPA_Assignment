package com.jpa.input;

import java.util.Scanner;

import com.jpa.entity.Customer;
import com.jpa.services.CustomerService;

public class CustomerInput 
{
    
    public static void main(String... args)
    {
        Scanner sc=new Scanner(System.in);
        CustomerService c=new CustomerService();
        System.out.println("Customer Management System : ");

        while (true)
        {
            System.out.println("1. Add Customer ");
            System.out.println("2. Display Customer");
            System.out.println("3. Search Customer ");
            System.out.println("4. Update  Customer ");
            System.out.println("5. Delete Customer ");
            System.out.println("6. Exit ");
            System.out.println("Enter your Choice :");
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                System.out.println("Enter Email : ");
                String email=sc.nextLine();
               

                System.out.println("Enter Name : ");
                String name=sc.nextLine();
                
                System.out.println("Enter Phone num : ");
                String phone_num=sc.nextLine();
                
                c.addCustomer(new Customer(email,name,phone_num));
                    
                break;


                case 2:
                c.displayCustomer();
                break;

                case 3:
                System.out.println("Enter Email : ");
                String email1=sc.nextLine();
                c.search_Customer(email1);
                break;
                case 4:
                System.out.println("Enter Email : ");
                String email2=sc.nextLine();
                

                System.out.println("Enter Name : ");
                String name2=sc.nextLine();

                System.out.println("Enter Phone num : ");
                String phone_num2=sc.nextLine();

                c.updateCustomer(email2, name2, phone_num2);
                break;

                case 5:

                System.out.println("Enter email: ");
                String email3=sc.nextLine();
                c.deleteCustomer(email3);
                break;

                case 6:
                System.out.println("Exiting.......");
                System.exit(0); 
                break;
                default:
                    break;
            }
        }
    }
}
