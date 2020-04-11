package com.example.ems.mapper;

import com.example.ems.Entity.sysdept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
public interface SysdeptMapper {
    //查重
    List<sysdept>selectBydeptname(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id")Integer id);

    void batchUpdataLevel(@Param("sysdepts") List<sysdept> sysdepts);

    List<sysdept>getDeptlistBychildLevel(@Param("level")String level);

    List<sysdept>getAllDept();

    int deleteByPrimaryKey(Integer id);

    int insert(sysdept record);

    int insertSelective(sysdept record);

    sysdept selectByPrimaryKey(Integer id);

    sysdept selectByDeptName(String name);

    int updateByPrimaryKeySelective(sysdept record);

    int updateByPrimaryKey(sysdept record);

    sysdept selectEnddata();
}