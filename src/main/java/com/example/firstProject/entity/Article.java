package com.example.firstProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
public class Article {

    @Id // 엔티티 대푯값 지정
    @GeneratedValue //자동 생성 기능 추가
    private Long id;

    @Column
    private String title;

    public Article() {
    }

    @Column
    private String content;

}
