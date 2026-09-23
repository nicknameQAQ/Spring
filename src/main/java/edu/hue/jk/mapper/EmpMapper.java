package edu.hue.jk.mapper;

import edu.hue.jk.model.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp")
    List<Emp> selectAll();

    @Select("select * from emp where empno = #{empno}")
    Emp selectByEmpno(@Param("empno") String empno);

    @Insert("insert into emp (empno, ename, hiredate, sal) " +
            "values (#{empno}, #{ename}, #{hiredate}, #{sal})")
    int insert(Emp emp);

    @Update("update emp set ename = #{ename}, hiredate = #{hiredate}, sal = #{sal} " +
            "where empno = #{empno}")
    int update(Emp emp);

    @Delete("delete from emp where empno = #{empno}")
    int deleteByEmpno(@Param("empno") String empno);
}