package com.example.ems.Service;

import com.example.ems.Entity.syspermodel;
import com.example.ems.Exception.paramException;
import com.example.ems.Utils.BeanValidator;
import com.example.ems.Utils.levelUtil;
import com.example.ems.mapper.SyspermodelMapper;
import com.example.ems.param.permodelParam;
import org.apache.ibatis.builder.ParameterExpression;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 9:55
 */
@Service
@Repository
public class SyspermodelService {
    @Resource
    private SyspermodelMapper syspermodelMapper;
    public void save(permodelParam param){
        BeanValidator.check(param);
        if (CheckExist(param.getName())){
            throw new paramException("该权限模块已存在");
        }
        syspermodel syspermodel = com.example.ems.Entity.syspermodel.builder().id(param.getId()).name(param.getName()).parentId(param.getParentid()).level(param.getLevel()).seq(param.getSeq()).build();
        syspermodel.setOperator("system");
        syspermodel.setOperateTime(new Date());
        syspermodel.setOperateIp("127.0.0.1");
        syspermodel.setId(param.getId());
        syspermodel.setLevel(levelUtil.calculatelevel(getLevel(param.getParentid()),param.getId()));
        syspermodelMapper.insertSelective(syspermodel);
    }

    /**
     * 通过父节点ID、获取父节点的level
     * @param parentid
     * @return
     */
    private String getLevel(Integer parentid) {
        syspermodel syspermodel = syspermodelMapper.selectByPrimaryKey(parentid);
        if (syspermodel == null){
            return null;
        }else {
            return syspermodel.getLevel();
        }
    }

    private boolean CheckExist(String name) {
        return syspermodelMapper.selectByname(name).size()>0;
    }
}
