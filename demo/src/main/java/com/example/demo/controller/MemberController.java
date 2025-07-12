package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.repositroy.MemberRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("api/signUp")
    public String addMember(MemberDto member) {
        //1. DTO 를 엔티티로 변환
        Member m = member.toEntity();

        //2. 레포지터리로 엔티티를 db에 저장
        Member saved = memberRepository.save(m);
        return saved!=null?"저장 되었습니다!":"저장에 실패 했습니다.";
    }
    @PostMapping("api/signIn")
    public String login(MemberDto member) {
        //1. DTO 를 엔티티로 변환
        Member m = member.toEntity();

        //2. 레포지터리로 엔티티를 db에 저장
        Member saved = memberRepository.save(m);
        return saved!=null?"저장 되었습니다!":"저장에 실패 했습니다.";
    }
}
