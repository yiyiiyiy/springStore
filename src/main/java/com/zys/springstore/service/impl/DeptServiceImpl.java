package com.zys.springstore.service.impl;

import com.zys.springstore.mapper.DeptMapper;
import com.zys.springstore.mapper.EmpMapper;
import com.zys.springstore.proj.Dept;
import com.zys.springstore.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);//根据ID删除部门数据

//        int i =1/0;

        empMapper.deleteByDeptId(id);//根据部门id删除该部门下的员工

        
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public Dept select(Integer id) {
        return deptMapper.select(id);
    }


}
