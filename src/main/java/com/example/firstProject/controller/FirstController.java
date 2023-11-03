package com.example.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "경환");
        model.addAttribute("username", "경");
        return "greetings"; // 이렇게 적어주면 서버가 알아서 templates 디렉토리에서 greetings.mustache를 찾아감
        // TODO : 왜 찾아가는 지 알아보자
    }
    @GetMapping("/bye")
        public String seeYouNext(Model model) {
        model.addAttribute("nickName", "홍길똥");
            return "goodbye";

    }


}
