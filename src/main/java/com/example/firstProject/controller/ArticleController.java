package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository; // DI 의존성 주입 - 만들어져 있는 객체를 사용함
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { //form 정보 매개변수로 받아옴
        log.info(form.toString());
//        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());
        //2. 리포지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        // 1.id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null); // Optional이나 orElse로 값 없을 때 처리를 해야 함
        model.addAttribute("article", articleEntity);
        // 2. 모델에 데이터 등록하기
        // 3. 뷰 페이지 반환하기

        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        // findAll이 Iterable로 나오기 때문에 형변환 해야함 1. 다운 캐스팅, 2. 업캐스팅 3. ArrayList 사용하기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지 설정하기


        return "articles/index";
    }


}
