package com.example.ems.mapper;

import com.example.ems.Entity.sysuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sysuser record);

    int insertSelective(sysuser record);

    sysuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sysuser record);

    int updateByPrimaryKey(sysuser record);

    sysuser selectByAcount(String acount);

    List<sysuser> selectByparams(@Param("username") String username,@Param("telephone") String telephone,@Param("mail") String mail,@Param("acount") String acount);

    List<sysuser> getall();
}