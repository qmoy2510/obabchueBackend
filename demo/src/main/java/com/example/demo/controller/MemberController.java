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
    public String signUp(MemberDto member) {
        //1. DTO 를 엔티티로 변환
        Member m = member.toEntity();

        //2. 레포지터리로 엔티티를 db에 저장
        Member saved = memberRepository.save(m);
        return saved!=null?"회원가입에 성공했습니다":"회원가입에 성공했습니다.";
    }
    @PostMapping("api/signIn")
    public String singIn(MemberDto member) {
        //1. DTO 를 엔티티로 변환
        Member m = member.toEntity();
        Member readMember = memberRepository.findById(m.getUserId()).orElse(null);
        if(readMember != null && readMember.getPassword() == m.getPassword()) {
            return "로그인에 성고하셨습니다!";
        }
        else{
            return "로그인에 실패하셨습니다";
        }

        //2. 레포지터리로 엔티티를 db에 저장

    }
}
