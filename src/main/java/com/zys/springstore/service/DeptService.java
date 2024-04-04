package com.zys.springstore.service;

import com.zys.springstore.proj.Dept;

import java.util.List;

public interface DeptService {
    //查询全部部门数据
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept select(Integer id);
}
