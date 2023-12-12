package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    private Boolean isLiked;

    public Likes(User user, Article article){
        this.user = user;
        this.article = article;
    }

    public Likes(){

    }

    public Integer getId(){
        return this.id;
    }

    public Integer getLikeUser(){
        return this.user.getId();
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setArticle(Article article){
        this.article = article;
    }

    public Integer getLikeArticle(){
        return this.article.getId();
    }

    public void setIsLiked(Boolean isLiked){
        this.isLiked = isLiked;
    }

    public Boolean getIsLiked(){
        return this.isLiked;
    }

}
