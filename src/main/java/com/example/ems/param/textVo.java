package com.example.ems.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class textVo {
    @NotNull(message = "id不能为空")
    @Max(value = 10,message = "id不能大于10")
    @Min(value = 0,message = "id必须大于等于1")
    private Integer id;
    @NotBlank
    private String msg;
}
