package com.jpa.entity;

//OneToMany - Bidirectional
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sales  //Owning side
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int quantity;


   @ManyToOne
   @JoinColumn(name = "prod_id")  //FK is created in Sales table 
   private Product product;

   public Sales (){}

   public Sales(int quantity, Product product) {
    this.quantity = quantity;
    this.product = product;
}
   public int getId() {
    return id;
   }


   public int getQuantity() {
    return quantity;
   }

   public void setQuantity(int quantity) {
    this.quantity = quantity;
   }

   public Product getProduct() {
    return product;
   }

   public void setProduct(Product product) {
    this.product = product;
   }

    
}
