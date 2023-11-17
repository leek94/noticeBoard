package com.example.firstProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    @Id // 엔티티 대푯값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성 기능 추가 --> DB가 id 자동 생성으로 변경
    private Long id;                                    // 더미가 추가해서 에러남 더미 값에서 id 값 없애고 DB가 생성하게 함

    @Column
    private String title;

    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
