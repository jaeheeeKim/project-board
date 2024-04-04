package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article { // ArticleDTO
    @Id // primarykey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 오토인크리먼트를 걸어주기 위해서
    private Long id;

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 내용

    @Setter private String hashtag; // 해시태그

    // JpaConfig에서 Auditing해주면 아래 어노테이션 사용 가능해짐
    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // 작성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createdBy; // 작성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy; // 수정자

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    // 도메인 Article을 생성 할 때 어던 값을 필요로 한다는 것을 가이드하는 부분!
    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    // @EqualsAndHashCode 롬복 대신 스켈레톤 코드를 만들어서 쓰기!
    // alt+insert > equals() and hashCode() >
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id);
        // 데이터베이스에 데이터를 연결 시키지 않았을때 아직 insert 하기 전 엔티티는 null이다 그래서 null 체크해야함!
        // id가 부여되지 않았다, 즉 영속화 되지 않았다고 하면 동등성 검사 자체가 의미가 없는걸로 보고 다 다른 것으로 간주하거나 혹은 처리하지 않겠다는 뜻!
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
