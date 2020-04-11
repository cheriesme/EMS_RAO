package com.example.ems.param;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Setter
@Getter
@ToString
public class DeptParam {
    private Integer id;
    @NotBlank(message="部门名不能为空")
    @Length(max = 20,min = 2,message = "部门长度为2-20")
    private String name;
    private Integer parentId;
    @NotNull(message = "展示的顺序不能为空")
    private Integer seq;
    @Length(max = 150,message = "备注长度最大为150")
    private String remark;
}
