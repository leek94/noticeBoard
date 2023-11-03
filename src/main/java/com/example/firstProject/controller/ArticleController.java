package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { //form 정보 매개변수로 받아옴
        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환
//        Article atricle = form.toEntity();
        //2. 리포지토리로 엔티티를 DB에 저장
        return "";
    }
}
