package com.example.accessingdatamysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "demo")
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping(path="/add/like")
    public @ResponseBody String addLike(@RequestBody LikeRequest likeRequest){

        Likes newLike = new Likes();
        newLike.setUser(userRepository.findById(likeRequest.getUserId()).get());
        newLike.setArticle(articleRepository.findById(likeRequest.getArticleId()).get());
        newLike.setIsLiked(likeRequest.getIsLiked());
        likeRepository.save(newLike);
        return "Like saved successfully";
    }

    @GetMapping(path = "/all/likes")
    public @ResponseBody Iterable<Likes> getAllLikes()  {
        return likeRepository.findAll();
    }

    @GetMapping(path = "/like/{id}")
    public @ResponseBody Optional<Likes> getLikeById(@PathVariable Integer id)  {
        return likeRepository.findById(id);
    }

    @PutMapping(path = "/update/like/{id}")
    public @ResponseBody String updateLike(@PathVariable Integer id, @RequestBody LikeRequest likeRequest){
        Likes like = likeRepository.findById(id).get();

        if(likeRequest.getUserId() != null){
            like.setUser(userRepository.findById(likeRequest.getUserId()).get());
        }

        if(likeRequest.getArticleId() != null){
            like.setArticle(articleRepository.findById(likeRequest.getArticleId()).get());
        }

        if(likeRequest.getIsLiked() != null){
            like.setIsLiked(likeRequest.getIsLiked());
            //return "Sí jala, según";
        }

        likeRepository.save(like);
        return "Like updated successfully";
    }

    @DeleteMapping(path = "/delete/like/{id}")
    public @ResponseBody String deleteLike(@PathVariable Integer id){
        likeRepository.deleteById(id);
        return "Like deleted successfully";
    }

}
