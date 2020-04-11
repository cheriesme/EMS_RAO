package com.example.ems.Entity;

public class sys_role_permissionKey {
    private Integer roleid;

    private Integer permissionid;

    public sys_role_permissionKey(Integer roleid, Integer permissionid) {
        this.roleid = roleid;
        this.permissionid = permissionid;
    }

    public sys_role_permissionKey() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}