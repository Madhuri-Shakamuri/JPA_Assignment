package com.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pub_id")
    private int id;
    @Column(name = "pub_name")
    private String name;

    public Publisher() 
    {

    }

    public List<Titles> getTitles() {
        return titles;
    }

    public void setTitles(List<Titles> titles) {
        this.titles = titles;
    }

    public Publisher(String name) 
    {
        this.name = name;
    }

    // Uni directional
    // @OneToMany //here a foreign key is created in titles table referencing to the
    // id(PK) of publisher table
    // @JoinColumn(name = "pubisher_id")
    // private List<Titles> titles;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Bi-directinal
    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)

    private List<Titles> titles=new ArrayList<>();

}
