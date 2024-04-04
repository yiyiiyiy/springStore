package com.zys.springstore.controller;

import com.zys.springstore.proj.Dept;
import com.zys.springstore.proj.Result;
import com.zys.springstore.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //日志对象
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//请求方式为GET
    @GetMapping
    public Result list(){
        log.info("查询全部的数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("查询数据{}",id);
        Dept dept =  deptService.select(id);
        return Result.success(dept);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除数据:{}",id);

        deptService.delete(id);

        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("增添数据{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("编辑数据{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
