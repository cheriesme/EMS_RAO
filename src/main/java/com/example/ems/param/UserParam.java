package com.example.ems.param;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class UserParam {
    private Integer id;
    @NotBlank(message = "姓名不能为空")
    @Length(min = 2, max = 10 ,message = "姓名长度为2-10")
    private String username;
    private Integer age;
    private Integer gender;
    private String telephone;
    private String mail;
    @NotBlank(message = "账号不能为空")
    private String acount;
    @NotBlank(message = "密码不能为空")
    private String password;
    private String remark;
    @NotNull(message = "部门ID不能为空")
    private Integer deptid;
    private Integer status;
    @NotNull(message = "角色ID不能为空")
    private Integer roleid;
    private String rolename;
}
