package com.personalBloggingapi.pb.service;

import com.personalBloggingapi.pb.entity.Article;
import com.personalBloggingapi.pb.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepo;

    public List<Article> getAllArticles(){
        return blogRepo.findAll();
    }

    public Optional<Article> getArticleById(int id){
        return blogRepo.findById(id);
    }

    public Article addArticle(Article article){
        return blogRepo.save(article);
    }
}
