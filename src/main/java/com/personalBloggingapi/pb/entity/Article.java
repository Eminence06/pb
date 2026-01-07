package com.personalBloggingapi.pb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
public class Article {
    @Id
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String tag;
    private Date publishedDate;
    private String status;
    private Date createdAt;
    private Date updatedBy;


}
