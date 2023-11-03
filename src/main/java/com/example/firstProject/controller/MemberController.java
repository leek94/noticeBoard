package com.example.firstProject.controller;

import com.example.firstProject.dto.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/member/new")
    public String newMemberForm(){
        return "member/new";
    }


    @PostMapping("/member/create")
    public String createMember(MemberForm form) {
        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        //2. 리포지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";

    }
}
