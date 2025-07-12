package com.example.demo.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "사용자별 카테고리 클릭/선호도 기록")
public class UserCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "PK")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    @Schema(description = "사용자(Member)")
    private Member user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Schema(description = "카테고리(Category)")
    private Category category;

    @Schema(description = "해당 카테고리 클릭/선호도 카운트", example = "3")
    private int count = 1;

    public UserCategory() {}
    public UserCategory(Member user, Category category) {
        this.user = user;
        this.category = category;
    }
    public Long getId() { return id; }
    public Member getUser() { return user; }
    public void setUser(Member user) { this.user = user; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
} 