package com.personalBloggingapi.pb.repository;

import com.personalBloggingapi.pb.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Article,Integer> {
}
