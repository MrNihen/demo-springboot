package com.nihen.springbootdemomybatisplus.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nihen.springbootdemomybatisplus.entity.dto.StudentDTO;
import com.nihen.springbootdemomybatisplus.entity.po.Student;
import com.nihen.springbootdemomybatisplus.entity.vo.StudentVO;
import com.nihen.springbootdemomybatisplus.mapper.StudentMapper;
import com.nihen.springbootdemomybatisplus.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<StudentVO> studentList() {
        StudentVO studentVO = new StudentVO();
        List<StudentVO> studentVOList = new ArrayList<>();
        List<Student> studentList = studentMapper.selectList(null);
        for (Student student : studentList){
            studentVO.setSid(student.getSid());
            studentVO.setSname(student.getSname());
            studentVO.setSex(student.getSex());
            studentVO.setAge(student.getAge());
            studentVO.setAddr(student.getAddr());
        }
        return null;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setSid(IdUtil.getSnowflake(0,1).nextId());
        student.setSname(studentDTO.getSname());
        student.setSex(studentDTO.getSex());
        student.setAge(studentDTO.getAge());
        student.setAddr(studentDTO.getAddr());
    }
}
