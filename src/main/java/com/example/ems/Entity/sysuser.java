package com.example.ems.Entity;

import lombok.Builder;

import java.util.Date;
@Builder
public class sysuser {
    private Integer id;

    private String username;

    private Integer gender;

    private Integer age;

    private String telephone;

    private String mail;

    private String acount;

    private String password;

    private String remark;

    private Integer deptId;

    private Integer status;

    private String operator;

    private Date operateTime;

    private String operateIp;

    private Integer roleId;

    private String rolename;

    public sysuser(Integer id, String username, Integer gender, Integer age, String telephone, String mail, String acount, String password, String remark, Integer deptId, Integer status, String operator, Date operateTime, String operateIp, Integer roleId, String rolename) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.telephone = telephone;
        this.mail = mail;
        this.acount = acount;
        this.password = password;
        this.remark = remark;
        this.deptId = deptId;
        this.status = status;
        this.operator = operator;
        this.operateTime = operateTime;
        this.operateIp = operateIp;
        this.roleId = roleId;
        this.rolename = rolename;
    }

    public sysuser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}