package com.personalBloggingapi.pb.controller;

import com.personalBloggingapi.pb.dto.ArticleRequest;
import com.personalBloggingapi.pb.dto.ArticleResponse;
import com.personalBloggingapi.pb.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
@RequiredArgsConstructor
public class BlogController {


    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<ArticleResponse> create(@Valid @RequestBody ArticleRequest articleRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.createArticle(articleRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getArticleById(id));
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getAllArticles(){
        return ResponseEntity.ok(blogService.getAllArticles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        blogService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }




}


