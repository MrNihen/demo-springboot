package com.nihen.springbootdemomybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihen.springbootdemomybatisplus.entity.dto.StudentDTO;
import com.nihen.springbootdemomybatisplus.entity.po.Student;
import com.nihen.springbootdemomybatisplus.entity.vo.StudentVO;
import com.nihen.springbootdemomybatisplus.util.PageSelectDTO;

import java.util.List;

/**
 * <p>
 *  学生服务接口
 * </p>
 *
 * @author 朱广龙
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
     * @param studentDTO 学生传输实体
     */
    void addStudent(StudentDTO studentDTO);

    /**
     * 修改学生信息
     * @param studentDTO 学生传输实体
     */
    void updateStudent(StudentDTO studentDTO);

    /**
     * 根据学生id删除学生信息
     * @param ids 学生ID数组
     */
    void deleteStudent(Long[] ids);

    /**
     * 分页列表学生
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @return List<StudentVO>
     */
    PageSelectDTO<StudentVO> selectStudentByPage(Integer pageNo, Integer pageSize);

    /**
     * 分页搜索学生信息
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @param studentDTO 学生接收实体对象
     * @return PageSelectDTO<StudentVO>
     */
    PageSelectDTO<StudentVO> searchStudentByPage(Integer pageNo, Integer pageSize, StudentDTO studentDTO);
}
