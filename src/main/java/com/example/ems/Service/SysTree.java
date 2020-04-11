package com.example.ems.Service;

import com.example.ems.Entity.sysdept;
import com.example.ems.Utils.levelUtil;
import com.example.ems.dto.DeptLevelDto;
import com.example.ems.mapper.SysdeptMapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SysTree {
@Resource
private SysdeptMapper sysdeptMapper;
public  List<DeptLevelDto>deptTree()throws Exception{
    List<sysdept> deptList = sysdeptMapper.getAllDept();
    List<DeptLevelDto> dtoList = Lists.newArrayList();
    for (sysdept dept : deptList){
       DeptLevelDto dto =DeptLevelDto.adapt(dept);
    dtoList.add(dto);
}
    return deptListToTree(dtoList);
}
public List<DeptLevelDto> deptListToTree(List<DeptLevelDto> deptlevelList){
    if(CollectionUtils.isEmpty(deptlevelList)){
        return Lists.newArrayList();
    }
    //从Mulitimao来的数据格式是：level->[dept1,dept1,...]
    Multimap<String,DeptLevelDto>levelDeptMap = ArrayListMultimap.create();
    List<DeptLevelDto> rootList = Lists.newArrayList();
    for (DeptLevelDto dto : deptlevelList){
        levelDeptMap.put(dto.getLevel(),dto);
        if (levelUtil.ROOT.equals(dto.getLevel())){
            rootList.add(dto);
        }
    }
    Collections.sort(rootList, new Comparator<DeptLevelDto>() {
        @Override
        public int compare(DeptLevelDto o1, DeptLevelDto o2) {
            return 0;
        }
    });
    //按照seq从小到大排序；
    Collections.sort(rootList, new Comparator<DeptLevelDto>() {
        @Override
        public int compare(DeptLevelDto o1, DeptLevelDto o2) {
            return o1.getSeq()-o2.getSeq();
        }
    });
    //递归生成树
    transforDeptTree(rootList, levelUtil.ROOT, levelDeptMap);
    return rootList;
}
public void transforDeptTree(List<DeptLevelDto> deptLevelList,String level,Multimap<String,DeptLevelDto>levelDeptMap){
    for (int i=1;i<deptLevelList.size();i++){
       //遍历该层的每一个元素
        DeptLevelDto deptLevelDto = deptLevelList.get(i);
       //处理当前层级的数据
        String nextLevel = levelUtil.calculatelevel(level,deptLevelDto.getId());
       // 处理下一层List
        List<DeptLevelDto> tempDeptList = (List<DeptLevelDto>)levelDeptMap.get(nextLevel);
        if (CollectionUtils.isNotEmpty(tempDeptList)){
            //排序
            Collections.sort(tempDeptList,deptSeqCompartor);
            //设置下一层部门
            deptLevelDto.setDeptList(tempDeptList);
            //进入下一层处理
            transforDeptTree(tempDeptList,nextLevel,levelDeptMap);
        }
    }
}
public Comparator<DeptLevelDto> deptSeqCompartor = new Comparator<DeptLevelDto>() {
    @Override
    public int compare(DeptLevelDto o1, DeptLevelDto o2) {
        return o1.getSeq()-o2.getSeq();
    }
};
}
