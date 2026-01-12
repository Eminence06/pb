package com.personalBloggingapi.pb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequest {

    @NotBlank
    @Size(min = 5, max = 150)
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String author;
    private String tag;
}
