package com.zys.springstore.mapper;

import com.zys.springstore.proj.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public Long count();
//
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);

//    @Select("select * from emp ")
    public List<Emp> list(String name , Short gender, LocalDate begin, LocalDate end);

    void deleEmps(List<Integer> ids);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp select(Integer id);

//    @Update("update emp set username = #{username}, password =#{password}, name =#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id =#{id}")
    void update(Emp emp);

    //根据用户名和密码查询员工
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUserNameAndPassword(Emp emp);

    //根据部门id删除部门下的员工数据
    @Delete("delete from emp where dept_id =#{deptId}")
    void deleteByDeptId(Integer deptId);

}
