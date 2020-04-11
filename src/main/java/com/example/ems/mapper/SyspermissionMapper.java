package com.example.ems.mapper;

import com.example.ems.Entity.syspermission;

import java.util.List;

public interface SyspermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(syspermission record);

    int insertSelective(syspermission record);

    syspermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(syspermission record);

    int updateByPrimaryKey(syspermission record);

    List<syspermission> getAll();

    List<syspermission> selectByname(String name);

    syspermission selectEnd();
}