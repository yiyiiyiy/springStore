package com.zys.springstore.controller;

import com.zys.springstore.proj.Emp;
import com.zys.springstore.proj.PageBean;
import com.zys.springstore.proj.Result;
import com.zys.springstore.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name , Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        if(page==null) page =1;
//        if(pageNum==null) pageNum =10;
        log.info("分页查询,参数{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean = empService.page(page,pageSize,name ,gender, begin, end);
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result deleteEmps(@PathVariable List<Integer> ids){
        log.info("删除的数据",ids);
        empService.deleteEmps(ids);
        return Result.success();
    }

    @PostMapping()
    public Result addEmp(@RequestBody Emp emp){
        log.info("增加员工{}",emp);
        empService.addEmp(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("查询的id:{}",id);
        Emp emp = empService.select(id);
        return Result.success(emp);
    }

    @PutMapping()
    public Result update(@RequestBody Emp emp){
        log.info("更改的数据id:{}",emp);
        empService.upadate(emp);
        return Result.success();
    }


}
