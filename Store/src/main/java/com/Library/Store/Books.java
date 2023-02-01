package com.Library.Store;

import jakarta.persistence.*;

@Entity
@Table
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Book name")
    private String name;
    @Column(name = "Author name")
    private String author;
    @Column(name = "Date of publish")
    private int datePublished;

    public Integer getId(){
        return this.id;
    }
    public Books(){
        super();
    }
    public Books(String name, String author, int datePublished){
        this.name = name;
        this.author = author;
        this.datePublished = datePublished;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setDatePublished(int datePublished){
        this.datePublished = datePublished;
    }
    public String getName(){
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public int getDatePublished(){
        return this.datePublished;
    }

}
