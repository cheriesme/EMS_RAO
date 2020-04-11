package com.example.ems.Entity;

public class sysdeptpermissionKey {
    private Integer deptid;

    private Integer permissionid;

    public sysdeptpermissionKey(Integer deptid, Integer permissionid) {
        this.deptid = deptid;
        this.permissionid = permissionid;
    }

    public sysdeptpermissionKey() {
        super();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}