package com.nihen.springbootdemomybatisplus.controller;


import com.nihen.springbootdemomybatisplus.entity.dto.StudentDTO;
import com.nihen.springbootdemomybatisplus.service.IStudentService;
import com.nihen.springbootdemomybatisplus.util.Result;
import com.nihen.springbootdemomybatisplus.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 查询学生列表
     * @return Result
     */
    @GetMapping("/studentList")
    public Result studentList(){
        try {
            return new Result(StatusCode.OK,true,"查询学生列表成功！",studentService.studentList());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"查询学生列表失败！");
        }
    }

    /**
     * 添加学生
     * @param studentDTO 学生传输实体
     * @return Result
     */
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody StudentDTO studentDTO){
        try {
            studentService.addStudent(studentDTO);
            return new Result(StatusCode.OK,true,"添加学生列表成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"添加学生列表失败！");
        }
    }

}
