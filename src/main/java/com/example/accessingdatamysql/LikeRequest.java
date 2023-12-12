package com.example.accessingdatamysql;

public class LikeRequest {

    private Integer userId;
    private Integer articleId;
    private Boolean isLiked;

    public LikeRequest(Integer userId, Integer articleId, Boolean isLiked){
        this.userId = userId;
        this.articleId = articleId;
        this.isLiked = isLiked;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public Integer getArticleId(){
        return this.articleId;
    }

    public Boolean getIsLiked(){
        return this.isLiked;
    }
}
