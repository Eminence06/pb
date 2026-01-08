package com.personalBloggingapi.pb.controller;

import com.personalBloggingapi.pb.entity.Article;
import com.personalBloggingapi.pb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blog/api")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/allblog")
    public ResponseEntity<List<Article>> getAllBlog(){
        return ResponseEntity.ok(blogService.getAllArticles());
    }

    @GetMapping("/allblog/{id}")
    public ResponseEntity<Optional<Article>> getBlogById(@PathVariable int id){
        return ResponseEntity.ok(blogService.getArticleById(id));
    }

    @PostMapping("/allblog/new")
    public ResponseEntity<String> addBlogById(@RequestBody Article article) throws Exception {

        Article article1 = blogService.addArticle(article);
        if(article1 == null){
            throw new Exception("NO data found");
        }
        return ResponseEntity.ok("Success");
    }
}
