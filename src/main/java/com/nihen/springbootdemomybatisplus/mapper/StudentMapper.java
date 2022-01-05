package com.nihen.springbootdemomybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nihen.springbootdemomybatisplus.entity.po.Student;
import com.nihen.springbootdemomybatisplus.entity.vo.StudentVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 学生信息的模糊查询带分页
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @param sid 学生id
     * @param sname 学生姓名
     * @param sex 学生性别
     * @param age 学生年龄
     * @param addr 地址
     * @param cname 班级
     * @return List<StudentVO>
     */
    List<StudentVO> searchStudentByPage(Integer pageNo, Integer pageSize, Long sid, String sname, String sex, Integer age, String addr, String cname);
}
