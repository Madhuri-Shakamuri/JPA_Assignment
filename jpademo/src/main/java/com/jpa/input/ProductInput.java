package com.jpa.input;

import java.util.Scanner;

import com.jpa.entity.Product;
import com.jpa.services.ProductService;

public class ProductInput 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        ProductService p=new ProductService();
        System.out.println("Product Management System");

        System.out.println("Provide Details for Product -1");
        System.out.println("Enter the product Name: ");
        String prod_name1=sc.nextLine();
        System.out.println("Enter the product Price: ");
        double prod_price1=sc.nextDouble();

        sc.nextLine();
        
        System.out.println("Provide Details for Product -2");
        System.out.println("Enter the product Name: ");
        String prod_name2=sc.nextLine();
        
        System.out.println("Enter the product Price: ");
        double prod_price2=sc.nextDouble();
        p.addProduct(new Product(prod_name1,prod_price1),new Product(prod_name2,prod_price2));

      






    }
    
}
