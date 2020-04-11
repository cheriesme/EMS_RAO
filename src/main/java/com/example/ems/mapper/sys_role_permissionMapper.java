package com.example.ems.mapper;

import com.example.ems.Entity.sys_role_permission;
import com.example.ems.Entity.sys_role_permissionKey;

public interface sys_role_permissionMapper {
    int deleteByPrimaryKey(sys_role_permissionKey key);

    int insert(sys_role_permission record);

    int insertSelective(sys_role_permission record);

    sys_role_permission selectByPrimaryKey(sys_role_permissionKey key);

    int updateByPrimaryKeySelective(sys_role_permission record);

    int updateByPrimaryKey(sys_role_permission record);
}