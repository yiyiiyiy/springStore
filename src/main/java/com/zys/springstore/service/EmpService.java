package com.zys.springstore.service;

import com.zys.springstore.proj.Emp;
import com.zys.springstore.proj.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name , Short gender,
                  LocalDate begin, LocalDate end);

    void deleteEmps(List<Integer> ids);

    void addEmp(Emp emp);

    Emp select(Integer id);

    void upadate(Emp emp);

    Emp logim(Emp emp);
}
