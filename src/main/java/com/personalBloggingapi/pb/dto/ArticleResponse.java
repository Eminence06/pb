package com.personalBloggingapi.pb.dto;

import com.personalBloggingapi.pb.entity.ArticleStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String tag;
    private ArticleStatus status;
    private LocalDateTime createdAt;
}
