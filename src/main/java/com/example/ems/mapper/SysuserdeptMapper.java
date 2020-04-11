package com.example.ems.mapper;

import com.example.ems.Entity.sysuserdept;
import com.example.ems.Entity.sysuserdeptKey;

public interface SysuserdeptMapper {
    int deleteByPrimaryKey(sysuserdeptKey key);

    int insert(sysuserdept record);

    int insertSelective(sysuserdept record);

    sysuserdept selectByPrimaryKey(sysuserdeptKey key);

    int updateByPrimaryKeySelective(sysuserdept record);

    int updateByPrimaryKey(sysuserdept record);
}