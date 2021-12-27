package com.nihen.springbootdemomybatisplus.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nihen.springbootdemomybatisplus.entity.dto.StudentDTO;
import com.nihen.springbootdemomybatisplus.entity.po.Classes;
import com.nihen.springbootdemomybatisplus.entity.po.Student;
import com.nihen.springbootdemomybatisplus.entity.po.StudentClasses;
import com.nihen.springbootdemomybatisplus.entity.vo.StudentVO;
import com.nihen.springbootdemomybatisplus.mapper.ClassesMapper;
import com.nihen.springbootdemomybatisplus.mapper.StudentClassesMapper;
import com.nihen.springbootdemomybatisplus.mapper.StudentMapper;
import com.nihen.springbootdemomybatisplus.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  学生服务实现类
 * </p>
 *
 * @author zhuguanglong
 * @since 2021-12-16
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentClassesMapper studentClassesMapper;

    @Autowired
    private ClassesMapper classesMapper;


    @Override
    public List<StudentVO> studentList() {
        //创建返回的学生对象
        List<StudentVO> studentVOList = new ArrayList<>();
        //从书库查询所有学生信息
        List<Student> studentList = studentMapper.selectList(null);
        log.info("studentList start studentList={}",studentList);
        //循环添加StudentVO信息
        for (Student student : studentList){
            StudentVO studentVO = new StudentVO();
            studentVO.setSid(student.getSid());
            studentVO.setSname(student.getSname());
            studentVO.setSex(student.getSex());
            studentVO.setAge(student.getAge());
            studentVO.setAddr(student.getAddr());
            log.info("studentVO start studentVO={}",studentVO);
            //构造学生班级搜索条件
            LambdaQueryWrapper<StudentClasses> studentClassesQueryWrapper = Wrappers.lambdaQuery();
            studentClassesQueryWrapper.eq(StudentClasses::getSid,student.getSid());
            //在中间表中根据sid查找cid
            Long cid = studentClassesMapper.selectOne(studentClassesQueryWrapper).getCid();
            log.info("cid start cid={}",cid);
            //构造搜索条件,
            LambdaQueryWrapper<Classes> classesLambdaQueryWrapper = Wrappers.lambdaQuery();
            classesLambdaQueryWrapper.eq(Classes::getCid,cid);
            //根据中间表查出的cid从classes表中查询对应的班级名称，并绑定studentVO
            studentVO.setCname(classesMapper.selectOne(classesLambdaQueryWrapper).getCname());
            log.info("studentVO end studentVO={}",studentVO);
            //循环添加到studentVOList
            studentVOList.add(studentVO);
        }
        log.info("studentList end studentList={}",studentList);
        return studentVOList;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        log.info("studentDTO start studentDTO={}",studentDTO);
        //添加班级
        Classes classes1 = new Classes();
        classes1.setCid(IdUtil.getSnowflake(0,1).nextId());
        classes1.setCname(studentDTO.getCname());
        log.info("classes1 start classes1={}",classes1);
        List<Object> objects = new ArrayList<>();
        for (Classes classes : classesMapper.selectList(null)){
            objects.add(classes.getCname());
            log.info("objects start objects={}",objects);
        }
        if (studentDTO.getCname() != null && !objects.contains(studentDTO.getCname())){
            classesMapper.insert(classes1);
        }

        //添加学生
        Student student = new Student();
        student.setSid(IdUtil.getSnowflake(0,1).nextId());
        student.setSname(studentDTO.getSname());
        student.setSex(studentDTO.getSex());
        student.setAge(studentDTO.getAge());
        student.setAddr(studentDTO.getAddr());
        log.info("student start student={}",student);
        studentMapper.insert(student);

        //添加学生班级表
        StudentClasses studentClasses = new StudentClasses();
        studentClasses.setId(IdUtil.getSnowflake(1,1).nextId());
        studentClasses.setSid(student.getSid());
        log.info("studentClasses start studentClasses={}",studentClasses);
        //构造搜索条件,
        LambdaQueryWrapper<Classes> classesLambdaQueryWrapper = Wrappers.lambdaQuery();
        classesLambdaQueryWrapper.eq(Classes::getCname,studentDTO.getCname());
        studentClasses.setCid(classesMapper.selectOne(classesLambdaQueryWrapper).getCid());
        log.info("studentClasses end studentClasses={}",studentClasses);
        studentClassesMapper.insert(studentClasses);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        log.info("studentDTO end studentDTO={}",studentDTO);
        List<Classes> classesList = classesMapper.selectList(null);
        List<Object> objects = new ArrayList<>();
        for (Classes classes1 : classesList){
            objects.add(classes1.getCname());
        }
        if (studentDTO.getCname() != null && objects.contains(studentDTO.getCname())){
            //更新学生信息
            Student student = new Student();
            student.setSid(studentDTO.getSid());
            student.setSname(studentDTO.getSname());
            student.setSex(studentDTO.getSex());
            student.setAge(studentDTO.getAge());
            student.setAddr(studentDTO.getAddr());
            log.info("student end student={}",student);
            studentMapper.updateById(student);

            //更新中间表信息
            StudentClasses studentClasses = new StudentClasses();
            //构造搜索条件,
            LambdaQueryWrapper<StudentClasses> studentClassesLambdaQueryWrapper = Wrappers.lambdaQuery();
            studentClassesLambdaQueryWrapper.eq(StudentClasses::getSid,studentDTO.getSid());
            studentClasses.setId(studentClassesMapper.selectOne(studentClassesLambdaQueryWrapper).getId());
            studentClasses.setSid(studentDTO.getSid());
            Classes classes = new Classes();
            LambdaQueryWrapper<Classes> classesLambdaQueryWrapper = Wrappers.lambdaQuery();
            classesLambdaQueryWrapper.eq(Classes::getCname,studentDTO.getCname());
            studentClasses.setCid(classesMapper.selectOne(classesLambdaQueryWrapper).getCid());
            studentClassesMapper.updateById(studentClasses);
        }else if (studentDTO.getCname() != null && !objects.contains(studentDTO.getCname())){
            //更新学生信息
            Student student = new Student();
            student.setSid(studentDTO.getSid());
            student.setSname(studentDTO.getSname());
            student.setSex(studentDTO.getSex());
            student.setAge(studentDTO.getAge());
            student.setAddr(studentDTO.getAddr());
            log.info("student end student={}",student);
            studentMapper.updateById(student);

            //添加班级
            Classes classes = new Classes();
            classes.setCid(IdUtil.getSnowflake(0,1).nextId());
            classes.setCname(studentDTO.getCname());
            classesMapper.insert(classes);

            //更新中间表信息
            StudentClasses studentClasses = new StudentClasses();
            //构造搜索条件,
            LambdaQueryWrapper<StudentClasses> studentClassesLambdaQueryWrapper = Wrappers.lambdaQuery();
            studentClassesLambdaQueryWrapper.eq(StudentClasses::getSid,studentDTO.getSid());
            studentClasses.setId(studentClassesMapper.selectOne(studentClassesLambdaQueryWrapper).getId());
            studentClasses.setSid(studentDTO.getSid());
            studentClasses.setCid(classes.getCid());
            studentClassesMapper.updateById(studentClasses);
        }
    }

    @Override
    public void deleteStudent(Long[] ids) {
        if (ids.length != 0){
            for (Long id : ids){
                //删除学生信息
                studentMapper.deleteById(id);

                //构造搜索条件,
                LambdaQueryWrapper<StudentClasses> studentClassesLambdaQueryWrapper = Wrappers.lambdaQuery();
                studentClassesLambdaQueryWrapper.eq(StudentClasses::getSid,id);
                //删除中间表信息
                studentClassesMapper.delete(studentClassesLambdaQueryWrapper);
            }
        }
    }

}
