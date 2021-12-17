package com.nihen.springbootdemomybatisplus.controller;


import com.nihen.springbootdemomybatisplus.entity.dto.ClassesDTO;
import com.nihen.springbootdemomybatisplus.service.IClassesService;
import com.nihen.springbootdemomybatisplus.util.Result;
import com.nihen.springbootdemomybatisplus.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  班级前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private IClassesService classesService;

    /**
     * 添加班级
     * @param classesDTO
     * @return Result
     */
    @PostMapping("/add")
    public Result add(@RequestBody ClassesDTO classesDTO){
        try {
            classesService.add(classesDTO);
            return new Result(StatusCode.OK,true,"添加班级信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"添加班级信息失败！");
        }
    }

    /**
     * 查询所有班级
     * @return com.nihen.springbootdemomybatisplus.util.Result
     */
    @GetMapping("/findAll")
    public Result findAll(){
        try {
            return new Result(StatusCode.OK,true,"查询所有班级信息成功！",classesService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"查询所有班级信息失败！");
        }
    }

    /**
     *  分页查询所有班级
     * @param pageNo
     * @param pageSize
     * @return Result
     */
    @GetMapping("/findByPage")
    public Result findByPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
        try {
            return new Result(StatusCode.OK,true,"分页查询所有班级信息成功！",classesService.findByPage(pageNo,pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"分页查询所有班级信息失败！");
        }
    }

    /**
     * 模糊查询带分页
     * @param pageNo
     * @param pageSize
     * @param classesDTO
     * @return Result
     */
    @GetMapping("/searchByPage")
    public Result searchByPage(@RequestParam Integer pageNo,@RequestParam Integer pageSize,@RequestBody ClassesDTO classesDTO){
        try {
            return new Result(StatusCode.OK,true,"分页模糊查询所有班级信息成功！",classesService.searchByPage(pageNo,pageSize,classesDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"分页模糊查询所有班级信息失败！");
        }

    }

    /**
     * 根据id修改班级信息
     * @param classesDTO
     * @return Result
     */
    @PostMapping("/updateClasses")
    public Result updateClasses(@RequestBody ClassesDTO classesDTO){
        try {
            classesService.updateClasses(classesDTO);
            return new Result(StatusCode.OK,true,"修改班级信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"修改班级信息失败！");
        }
    }

    /**
     * 根据id删除班级信息
     * @param ids
     * @return Result
     */
    @DeleteMapping("/delectClasses")
    public Result delectClassesByIds(@RequestParam Long[] ids){
        try {
            classesService.delectClassesByIds(ids);
            return new Result(StatusCode.OK,true,"删除班级信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"删除班级信息失败！");
        }
    }

    @GetMapping("/findOne")
    public Result findOne(){
        try {
            return new Result(StatusCode.OK,true,"查找一个班级信息成功！", classesService.findOne());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.OK,true,"查找一个班级信息失败！");
        }
    }


}
