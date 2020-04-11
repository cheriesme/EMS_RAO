package com.example.ems.Service;

        import com.example.ems.Entity.sysdept;
        import com.example.ems.Exception.paramException;
        import com.example.ems.Utils.BeanValidator;
        import com.example.ems.Utils.levelUtil;

        import com.example.ems.mapper.SysdeptMapper;
        import com.example.ems.param.DeptParam;
        import com.google.common.base.Preconditions;
        import org.apache.commons.collections.CollectionUtils;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;


        import javax.annotation.Resource;
        import java.util.Date;
        import java.util.List;
@Repository
@Service
public class SysDeptService {
    @Resource
    private SysdeptMapper sysdeptMapper;
    public void save(DeptParam param){
        BeanValidator.check(param);
        if (checkExist(param.getParentId(),param.getName(),param.getId())){
         throw new paramException("同一层级下存在相同的部门");
        }
        sysdept dept = sysdept.builder().id(param.getId()).name(param.getName()).parentId(param.getParentId()).seq(param.getSeq()).remark(param.getRemark()).build();
                dept.setLevel(levelUtil.calculatelevel(getLevel(param.getParentId()),param.getId()));
                dept.setOperateIp("127.0.0.1");//TODO;
                dept.setOperateTime(new Date());//TODO;
                dept.setOperator("system");//TODO;
        sysdeptMapper.insertSelective(dept);
    }
    public void updata(DeptParam param){
        BeanValidator.check(param);
        sysdept before = sysdeptMapper.selectByPrimaryKey(param.getId());
        System.out.println("待更新的部门"+before);
        Preconditions.checkNotNull(before,"待更新的部门不存在");
        sysdept after = sysdept.builder().name(param.getName()).parentId(param.getParentId()).seq(param.getSeq()).remark(param.getRemark()).build();
//        after.setLevel(levelUtil.calculatelevel(getLevel(param.getParentId()),param.getParentId()));
        after.setLevel(levelUtil.calculatelevel(getLevel(param.getParentId()),param.getParentId()));
        after.setOperateIp("127.0.01");//TODO;
        after.setOperateTime(new Date());//TODO;
        after.setOperator("system-updata");//TODO;
        sysdeptMapper.updateByPrimaryKey(after);
//        updataWithChild(before,after);
    }
    @Transactional
    public void updataWithChild(sysdept before,sysdept after){
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        sysdeptMapper.updateByPrimaryKey(after);
        if (!newLevelPrefix.equals(oldLevelPrefix)){
            List<sysdept>deptList = sysdeptMapper.getDeptlistBychildLevel(oldLevelPrefix);
            System.out.println("元素列表"+deptList);
            if (CollectionUtils.isNotEmpty(deptList)){
                for (sysdept dept : deptList){
                    String level = dept.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0){
                        level = newLevelPrefix+level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                sysdeptMapper.batchUpdataLevel(deptList);
            }
        }

    }
    private boolean checkExist(Integer parentId,String deptname,Integer deptId){

        return sysdeptMapper.selectBydeptname(parentId,deptname,deptId).size()>0;
    }
    //通过parentid找到父节点的level
    private String  getLevel(Integer parentdeptId){
        sysdept dept = sysdeptMapper.selectByPrimaryKey(parentdeptId);
        if (dept == null){
            return null;
        }else {
            return dept.getLevel();
        }
    }
}
