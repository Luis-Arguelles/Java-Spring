package com.example.accessingdatamysql;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;
    private String content;

    public Article(User author, String content){
        this.author = author;
        this.content = content;
        setDate();
    }

    public Article(){

    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer newId){
        this.id = newId;
    }

    public LocalDateTime getDate(){
        return this.date;
    }

    public void setDate(){
        this.date = LocalDateTime.now();
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String newContent){
        this.content = newContent;
    }
}
