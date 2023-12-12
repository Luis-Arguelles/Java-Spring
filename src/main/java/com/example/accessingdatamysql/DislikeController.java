package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "demo")
public class DislikeController {

    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping(path="/add/dislike")
    public @ResponseBody String addDislike(@RequestBody DislikeRequest dislikeRequest){

        Dislike newDislike = new Dislike();
        newDislike.setUser(userRepository.findById(dislikeRequest.getUserId()).get());
        newDislike.setArticle(articleRepository.findById(dislikeRequest.getArticleId()).get());
        newDislike.setIsDisliked(dislikeRequest.getIsDisliked());
        dislikeRepository.save(newDislike);
        return "Dislike saved successfully";
    }

    @GetMapping(path = "/all/dislikes")
    public @ResponseBody Iterable<Dislike> getAllDislikes()  {
        return dislikeRepository.findAll();
    }

    @GetMapping(path = "/dislike/{id}")
    public @ResponseBody Dislike getDislikeById(@PathVariable Integer id)  {
        return dislikeRepository.findById(id).get();
    }

    @PutMapping(path = "/update/dislike/{id}")
    public @ResponseBody String updateDislike(@PathVariable Integer id, @RequestBody DislikeRequest dislikeRequest){
        Dislike dislike = dislikeRepository.findById(id).get();

        if(dislikeRequest.getUserId() != null){
            dislike.setUser(userRepository.findById(dislikeRequest.getUserId()).get());
        }

        if(dislikeRequest.getArticleId() != null){
            dislike.setArticle(articleRepository.findById(dislikeRequest.getArticleId()).get());
        }

        if(dislikeRequest.getIsDisliked() != null){
            dislike.setIsDisliked(dislikeRequest.getIsDisliked());
        }

        dislikeRepository.save(dislike);
        return "Dislike updated successfully";
    }

    @DeleteMapping(path = "/delete/dislike/{id}")
    public @ResponseBody String deleteDislike(@PathVariable Integer id){
        dislikeRepository.deleteById(id);
        return "Dislike deleted successfully";
    }
}
