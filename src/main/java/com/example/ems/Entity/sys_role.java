package com.example.ems.Entity;

import lombok.Builder;

import java.util.Date;
@Builder
public class sys_role {
    private Integer id;

    private String name;

    private String operator;

    private String operateip;

    private Date operatetime;

    public sys_role(Integer id, String name, String operator, String operateip, Date operatetime) {
        this.id = id;
        this.name = name;
        this.operator = operator;
        this.operateip = operateip;
        this.operatetime = operatetime;
    }

    public sys_role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperateip() {
        return operateip;
    }

    public void setOperateip(String operateip) {
        this.operateip = operateip == null ? null : operateip.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }
}