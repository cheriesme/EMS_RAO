package com.example.ems.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 9:51
 */
@Data
public class permodelParam {
    private Integer id;
    @NotBlank(message = "模块名称不能为空")
    private String name;
    @NotNull(message = "父模块节点不能为空")
    private Integer parentid;
    private String level;
    private Integer seq;
    private String remark;
}
