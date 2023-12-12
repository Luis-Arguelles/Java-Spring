package com.example.accessingdatamysql;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private LocalDateTime date;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private User author;
    private String content;

    public Article(User author, String content){
        this.author = author;
        this.content = content;
        setDate();
    }

    public Article(){
        setDate();
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

    public User getAuthor(){
        return this.author;
    }

    public int getAuthorId(){
        return this.author.getId();
    }

    public void setAuthor(User newAuthor){
        this.author = newAuthor;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String newContent){
        this.content = newContent;
    }

    @OneToMany(mappedBy = "article")
    private Collection<Likes> likes;
}
