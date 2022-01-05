package com.nihen.springbootdemomybatisplus.controller;


import com.nihen.springbootdemomybatisplus.entity.dto.StudentDTO;
import com.nihen.springbootdemomybatisplus.service.IStudentService;
import com.nihen.springbootdemomybatisplus.util.Result;
import com.nihen.springbootdemomybatisplus.util.StatusCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学生控制器
 * @author zhuguanglong
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
    @ApiOperation("查询学生列表")
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
    @ApiOperation("添加学生")
    @PostMapping("/addStudent")
    public Result addStudent(@ApiParam("studentDTO") @RequestBody StudentDTO studentDTO){
        try {
            studentService.addStudent(studentDTO);
            return new Result(StatusCode.OK,true,"添加学生列表成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"添加学生列表失败！");
        }
    }

    /**
     * 修改学生信息
     * @param studentDTO 学生传输实体
     * @return Result
     */
    @ApiOperation("修改学生信息")
    @PostMapping("/updateStudent")
    public Result updateStudent(@ApiParam("studentDTO") @RequestBody StudentDTO studentDTO){
        try {
            studentService.updateStudent(studentDTO);
            return new Result(StatusCode.OK,true,"修改学生列表成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"修改学生列表失败！");
        }
    }

    /**
     * 根据id删除学生信息
     * @param ids 学生id
     * @return Result
     */
    @ApiOperation("根据id删除学生信息")
    @PostMapping("/deleteStudent")
    public Result deleteStudent(@ApiParam("ids") @RequestParam("ids") Long[] ids){
        try {
            studentService.deleteStudent(ids);
            return new Result(StatusCode.OK,true,"删除学生列表成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"删除学生列表失败！");
        }
    }

    @ApiOperation("分页列表学生")
    @PostMapping("/selectStudentByPage")
    public Result selectStudentByPage(@ApiParam("pageNo") @RequestParam("pageNo") Integer pageNo,@ApiParam("pageSize") @RequestParam("pageSize") Integer pageSize){
        try {
            return new Result(StatusCode.OK,true,"分页学生列表成功！",studentService.selectStudentByPage(pageNo,pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"分页学生列表失败！");
        }
    }

    @ApiOperation("搜索分页学生信息")
    @PostMapping("/searchStudentByPage")
    public Result searchStudentByPage(@ApiParam("pageNo") @RequestParam("pageNo") Integer pageNo,
                                      @ApiParam("pageSize") @RequestParam("pageSize") Integer pageSize,
                                      @ApiParam("studentDTO") @RequestBody StudentDTO studentDTO)
    {
        try {
            return new Result(StatusCode.OK,true,"搜索分页学生列表成功！",studentService.searchStudentByPage(pageNo,pageSize,studentDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"搜索分页学生列表失败！");
        }
    }



}
