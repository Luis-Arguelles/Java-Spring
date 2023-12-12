package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
public class Dislike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    private Boolean isDisliked;

    public Dislike(){

    }

    public Integer getUserId(){
        return this.user.getId();
    }

    public void setUser(User user){
        this.user = user;
    }
    public Integer getArticleId(){
        return this.article.getId();
    }

    public void setArticle(Article article){
        this.article = article;
    }

    public Boolean getIsDisliked(){
        return this.isDisliked;
    }

    public void setIsDisliked(Boolean isDisliked){
        this.isDisliked = isDisliked;
    }

}
