package com.example.ems.controller;

import com.example.ems.Entity.sysdept;
import com.example.ems.Service.SysDeptService;
import com.example.ems.Service.SysTree;
import com.example.ems.common.Jsondata;
import com.example.ems.dto.DeptLevelDto;
import com.example.ems.mapper.SysdeptMapper;
import com.example.ems.param.DeptParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dept")
@Slf4j
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;
    @Resource
    private SysdeptMapper sysdeptMapper;
    @Autowired
    private SysTree sysTree;

    /**
     * 增加一个部门
     * @param param
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/save.page")
    public String insert(DeptParam param,ModelMap map,HttpSession session) {
        sysdept dept = sysdeptMapper.selectEnddata();
        param.setId(dept.getId() + 1);
        System.out.println(dept);
        System.out.println(param);
        sysDeptService.save(param);
        List<sysdept> sysdeptList = sysdeptMapper.getAllDept();
        map.addAttribute("deptlist", sysdeptList);
        session.setAttribute("deptsize", sysdeptList.size());
        return "dept_table";
    }

    /**
     * 删除一个部门
     * @return
     */
    @RequestMapping("/delete.page/{id}")
    public String delete(@PathVariable("id")Integer id){
        sysdeptMapper.deleteByPrimaryKey(id);
        return "redirect:/dept/getdeptpage.page";
    }

    /**
     * 编辑部门
     * @param param
     * @return
     */


    @RequestMapping("/updata.json")
    @ResponseBody
    public Jsondata updata(DeptParam param) {
        param.setId(1);
        param.setName("远洋数据");
        param.setParentId(1);
        param.setRemark("更新测试");
        param.setSeq(1);
        System.out.println("开始" + param.getName());
        sysDeptService.updata(param);
        return Jsondata.success(param, "修改完成！");
    }

    @RequestMapping("/getdeptpage.page")
    public String getdept(ModelMap map, HttpSession session) {
        List<sysdept> sysdeptList = sysdeptMapper.getAllDept();
        map.addAttribute("deptlist", sysdeptList);
        session.setAttribute("deptsize", sysdeptList.size());
        return "dept_table.html";
    }

    @RequestMapping("/getdeptlist.json")
    @ResponseBody
    public Object getdeptlist() {
        List<sysdept> sysdeptList = sysdeptMapper.getAllDept();
        return sysdeptList;
    }

    @RequestMapping("/getdeptps.json")
    @ResponseBody
    public List<sysdept> getdept(ModelMap map) {
        List<sysdept> sysdeptList = sysdeptMapper.getAllDept();
        map.addAttribute("deptlistps", sysdeptList);
        return sysdeptList;
    }
}