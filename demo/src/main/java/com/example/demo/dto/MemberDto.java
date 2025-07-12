package com.example.demo.dto;

import com.example.demo.entity.Member;

public class MemberDto {
    private String userId;
    private String name;
    private int age;
    private int gender;
    private String password;

    public MemberDto(String userId, String name, int age, int gender, String password) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }


    public Member toEntity(){
        return new Member(userId, name, age, gender, password);
    }
}
