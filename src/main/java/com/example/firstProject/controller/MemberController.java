package com.example.firstProject.controller;

import com.example.firstProject.dto.MemberForm;
import com.example.firstProject.entity.Member;
import com.example.firstProject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

//    @GetMapping("/members")
//    public String newMemberForm(){
//        return "member/new";
//    }


    @PostMapping("/join")
    public String createMember(MemberForm form) {
        log.info(form.toString());
//        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());
        //2. 리포지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
//        System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "";
    }

    @GetMapping("/members")
    public String index(Model model) {
        Iterable<Member> memberEntityList = memberRepository.findAll();
        model.addAttribute("memberList", memberEntityList);
        return "";
    }
}
