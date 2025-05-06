package com.jpa.entity;
//Owning side 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Titles 
{
    @Id
    @Column(name = "title_id")
    private int id;
    @Column(name = "title_name")
    private String name;
    private double price ;  
    @ManyToOne
    @JoinColumn(name = "publishers_id") //FK is still created in tiltes table
    private Publisher publisher;
    
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public Titles()
    {

    }
    public Titles(String name,Publisher publisher) {
        this.name = name;
        this.publisher=publisher;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
   

    
   
   
   
    
}
