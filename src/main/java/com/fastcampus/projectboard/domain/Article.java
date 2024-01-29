package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
public class Article { // ArticleDTO
    @Id // primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 오토인크리먼트를 걸어주기 위해서
    private Long id;
    private String title; // 제목
    private String content; // 내용
    private String hashtag; // 해시태그

    private LocalDateTime createdAt; // 작성일시
    private String createdBy; // 작성자
    private LocalDateTime modifiedAt; // 수정일시
    private String modifiedBy; // 수정자
}
