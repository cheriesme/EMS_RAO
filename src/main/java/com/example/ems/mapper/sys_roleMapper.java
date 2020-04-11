package com.example.ems.mapper;

import com.example.ems.Entity.sys_role;

import java.util.Collection;
import java.util.List;

public interface sys_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sys_role record);

    int insertSelective(sys_role record);

    sys_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sys_role record);

    int updateByPrimaryKey(sys_role record);

    sys_role selectend();

    List<sys_role> selectByName(String name);

    List<sys_role> getAll();
}