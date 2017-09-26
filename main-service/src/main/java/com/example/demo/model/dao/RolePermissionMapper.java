package com.example.demo.model.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.po.RolePermission;

@Repository
public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}