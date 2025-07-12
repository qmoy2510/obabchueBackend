package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Member;
import com.example.demo.entity.UserCategory;
import com.example.demo.repositroy.CategoryRepository;
import com.example.demo.repositroy.MemberRepository;
import com.example.demo.repositroy.UserCategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.UserCategoryResponse;

@RestController
public class UserCategoryController {
    @Autowired
    private UserCategoryRepository userCategoryRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/api/addUserCategory")
    @Operation(
        summary = "유저 카테고리 카운트 증가",
        description = "userId와 categoryName을 받아 해당 유저의 카테고리 카운트를 1 증가시킵니다.\n- 이미 있으면 count+1, 없으면 새로 생성(count=1)\n\n요청 예시: /api/addUserCategory?userId=user123&categoryName=한식"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "변경된 UserCategory 정보 반환",
            content = @Content(schema = @Schema(implementation = UserCategoryResponse.class))
        )
    })
    public ResponseEntity<UserCategoryResponse> addUserCategory(
        @Parameter(description = "사용자 ID", example = "user123") @RequestParam String userId,
        @Parameter(description = "카테고리명", example = "한식") @RequestParam String categoryName
    ) {
        Member user = memberRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("존재하지 않는 사용자입니다.");
        }
        Category category = categoryRepository.findByName(categoryName);
        if (category == null) {
            return ResponseEntity.badRequest().body("존재하지 않는 카테고리입니다.");
        }
        UserCategory userCategory = userCategoryRepository.findByUserAndCategory(user, category);
        if (userCategory != null) {
            userCategory.setCount(userCategory.getCount() + 1);
        } else {
            userCategory = new UserCategory(user, category);
            userCategory.setCount(1);
        }
        userCategoryRepository.save(userCategory);
        return ResponseEntity.ok(new UserCategoryResponse(category.getName(), userCategory.getCount()));
    }
} 