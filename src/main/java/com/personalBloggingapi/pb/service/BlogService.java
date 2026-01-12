package com.personalBloggingapi.pb.service;

import com.personalBloggingapi.pb.dto.ArticleRequest;
import com.personalBloggingapi.pb.dto.ArticleResponse;
import com.personalBloggingapi.pb.entity.Article;
import com.personalBloggingapi.pb.entity.ArticleStatus;
import com.personalBloggingapi.pb.exception.ResourceNotFoundException;
import com.personalBloggingapi.pb.repository.BlogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {


    private final BlogRepo blogRepo;

    public ArticleResponse createArticle(ArticleRequest request){
        Article article = Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .tag(request.getTag())
                .status(ArticleStatus.DRAFT)
                .build();

        Article saved = blogRepo.save(article);
        log.info("Article created with id {}", saved.getId());
        return mapToResponse(saved);
    }

    public ArticleResponse getArticleById(Long id) {
        Article article = null;
        try {
            article = blogRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Article not found"));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Article not found");
        }
        return mapToResponse(article);
    }

    public List<ArticleResponse> getAllArticles(){
        return blogRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public void deleteArticle(Long id){
        if(!blogRepo.existsById(id)){
            throw new ResourceNotFoundException("Id not found");
        }
        blogRepo.deleteById(id);
    }




    private ArticleResponse mapToResponse(Article article){
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .author(article.getAuthor())
                .content(article.getContent())
                .title(article.getTitle())
                .tag(article.getTag())
                .status(article.getStatus())
                .createdAt(article.getCreatedAt())
                .build();
    }

}
