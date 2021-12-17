package com.nihen.springbootdemomybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihen.springbootdemomybatisplus.entity.dto.StudentDTO;
import com.nihen.springbootdemomybatisplus.entity.po.Student;
import com.nihen.springbootdemomybatisplus.entity.vo.StudentVO;

import java.util.List;

/**
 * <p>
 *  学生服务接口
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
public interface IStudentService extends IService<Student> {

    /**
     * 查询学生列表
     * @return List<StudentVO>
     */
    List<StudentVO> studentList();

    /**
     * 添加学生
     * @param studentDTO
     */
    void addStudent(StudentDTO studentDTO);
}
