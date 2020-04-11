package com.example.ems.param;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 9:05
 */
@Data
@ToString
public class PermissionParam {
    private Integer id;
    @NotBlank(message = "权限名不能为空")
    @Length(max = 20,min = 2,message = "长度为2-20")
    private String name;
    @NotNull(message = "权限模块ID不能为空")
    private Integer modelid;
    private String level;
    private Integer seq;
    @Length(message = "备注长度不能超过150字")
    private String remark;
}
