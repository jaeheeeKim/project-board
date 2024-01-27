package com.fastcampus.projectboard.domain;

import java.time.LocalDateTime;

public class Article { // ArticleDTO
    private Long id;
    private String title; // 제목
    private String content; // 내용
    private String hashtag; // 해시태그

    private LocalDateTime createdAt; // 작성일시
    private String createdBy; // 작성자
    private LocalDateTime modifiedAt; // 수정일시
    private String modifiedBy; // 수정자
}
