package com.example.accessingdatamysql;

import javax.persistence.*;
import java.util.Collection;

@Entity // This tells Hibernate to make a table out of this class
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;


    public User(String name, String email, String password, String role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(){
        this.name = "";
        this.email = "";
        this.password = "";
        this.role = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String newRole){
        this.role = newRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "author")
    private Collection<Article> articles;

    @OneToMany(mappedBy = "user")
    private Collection<Likes> likes;

    @OneToMany(mappedBy = "user")
    private Collection<Dislike> dislikes;
}