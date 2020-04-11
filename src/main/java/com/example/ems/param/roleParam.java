package com.example.ems.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 14:43
 */
@Data
public class roleParam {
    private Integer id;
    @NotBlank(message = "角色名称不能空")
    private String name;
}
