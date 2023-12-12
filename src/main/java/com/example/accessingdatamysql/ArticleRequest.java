package com.example.accessingdatamysql;

public class ArticleRequest {

    private Integer authorId;
    private String content;

    public ArticleRequest(Integer author, String content){
        this.authorId = author;
        this.content = content;
    }

    public Integer getAuthorId(){
        return this.authorId;
    }

    public void setAuthorId(Integer authorId){
        this.authorId = authorId;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
