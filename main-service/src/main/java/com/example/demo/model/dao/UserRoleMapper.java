package com.example.demo.model.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.po.UserRole;

@Repository
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}