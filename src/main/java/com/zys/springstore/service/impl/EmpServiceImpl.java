package com.zys.springstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zys.springstore.mapper.EmpMapper;
import com.zys.springstore.proj.Emp;
import com.zys.springstore.proj.PageBean;
import com.zys.springstore.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        Integer start = (page-1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//        PageBean pageBean = new PageBean(count,empList);
//        return pageBean;
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name , Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);

        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void deleteEmps(List<Integer> ids) {
        empMapper.deleEmps(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp select(Integer id) {
        return empMapper.select(id);
    }

    @Override
    public void upadate(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp logim(Emp emp) {
        return empMapper.getByUserNameAndPassword(emp);
    }
}
