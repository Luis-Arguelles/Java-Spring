package com.example.accessingdatamysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "demo")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add/article")
    public @ResponseBody String addNewArticle (@RequestBody ArticleRequest article){

        Article newArticle = new Article();
        newArticle.setContent(article.getContent());
        newArticle.setAuthor(userRepository.findById(article.getAuthorId()).get());
        articleRepository.save(newArticle);
        return "Article saved successfully";
    }

    @GetMapping(path = "/all/articles")
    public @ResponseBody Iterable<Article> getAllArticles()  {
        return articleRepository.findAll();
    }

    @PutMapping(path = "/update/article/{id}")
    public @ResponseBody String updateArticle (@PathVariable Integer id,@RequestBody ArticleRequest updatedArticle){
        Article article = articleRepository.findById(id).get();

        if(updatedArticle.getAuthorId() != null){
            article.setAuthor(userRepository.findById(updatedArticle.getAuthorId()).get());
        }

        if(!updatedArticle.getContent().isEmpty()){
            article.setContent(updatedArticle.getContent());
        }

        articleRepository.save(article);
        return "Article updated successfully";

    }

    @DeleteMapping(path = "/delete/article/{id}")
    public @ResponseBody String deleteArticle (@PathVariable Integer id){
        articleRepository.deleteById(id);
        return "Article deleted successfully";
    }
}
