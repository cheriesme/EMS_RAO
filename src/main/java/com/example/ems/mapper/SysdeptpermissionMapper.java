package com.example.ems.mapper;

import com.example.ems.Entity.sysdeptpermission;
import com.example.ems.Entity.sysdeptpermissionKey;

public interface SysdeptpermissionMapper {
    int deleteByPrimaryKey(sysdeptpermissionKey key);

    int insert(sysdeptpermission record);

    int insertSelective(sysdeptpermission record);

    sysdeptpermission selectByPrimaryKey(sysdeptpermissionKey key);

    int updateByPrimaryKeySelective(sysdeptpermission record);

    int updateByPrimaryKey(sysdeptpermission record);
}