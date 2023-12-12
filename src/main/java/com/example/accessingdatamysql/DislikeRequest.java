package com.example.accessingdatamysql;

public class DislikeRequest {

    private Integer userId;
    private Integer articleId;
    private Boolean isDisliked;

    public DislikeRequest(Integer userId, Integer articleId, Boolean isDisliked){
        this.userId = userId;
        this.articleId = articleId;
        this.isDisliked = isDisliked;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public Integer getArticleId(){
        return this.articleId;
    }

    public Boolean getIsDisliked(){
        return this.isDisliked;
    }
}
