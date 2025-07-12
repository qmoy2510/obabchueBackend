package com.example.demo.repositroy;

import com.example.demo.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {
    UserCategory findByUserAndCategory(com.example.demo.entity.Member user, com.example.demo.entity.Category category);
} 