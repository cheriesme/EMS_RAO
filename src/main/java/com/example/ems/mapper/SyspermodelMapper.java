package com.example.ems.mapper;

import com.example.ems.Entity.syspermodel;

import java.util.List;

public interface SyspermodelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(syspermodel record);

    int insertSelective(syspermodel record);

    syspermodel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(syspermodel record);

    int updateByPrimaryKey(syspermodel record);

    List<syspermodel> getAll();

    List<syspermodel> selectByname(String name);

    syspermodel selectend();
}