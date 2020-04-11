package com.example.ems.dto;

import com.example.ems.Entity.sysdept;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

@Getter
@ToString
@Setter
public class DeptLevelDto extends sysdept {
    private List<DeptLevelDto> deptList = Lists.newArrayList();
    public static DeptLevelDto adapt(sysdept dept)throws Exception{
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept,dto);
        return dto;
    }
}
