package com.nihen.springbootdemomybatisplus.controller;


import com.nihen.springbootdemomybatisplus.entity.dto.ClassesDTO;
import com.nihen.springbootdemomybatisplus.service.IClassesService;
import com.nihen.springbootdemomybatisplus.util.Result;
import com.nihen.springbootdemomybatisplus.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  班级前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@Api("班级控制器类")
@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private IClassesService classesService;

    /**
     * 添加班级
     * @param classesDTO 班级传输实体
     * @return Result
     */
    @ApiOperation("添加班级")
    @PostMapping("/add")
    public Result add(@ApiParam("classesDTO") @RequestBody ClassesDTO classesDTO){
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
    @ApiOperation("查询所有班级")
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
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @return Result
     */
    @ApiOperation("分页查询所有班级")
    @PostMapping("/findByPage")
    public Result findByPage(@ApiParam("pageNo") @RequestParam Integer pageNo,@ApiParam("pageSize") @RequestParam Integer pageSize){
        try {
            return new Result(StatusCode.OK,true,"分页查询所有班级信息成功！",classesService.findByPage(pageNo,pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"分页查询所有班级信息失败！");
        }
    }

    /**
     * 模糊查询带分页
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @param classesDTO 班级传输实体
     * @return Result
     */
    @ApiOperation("模糊查询带分页")
    @PostMapping("/searchByPage")
    public Result searchByPage(@ApiParam("pageNo") @RequestParam Integer pageNo,@ApiParam("pageSize") @RequestParam Integer pageSize,@ApiParam("classesDTO") @RequestBody ClassesDTO classesDTO){
        try {
            return new Result(StatusCode.OK,true,"分页模糊查询所有班级信息成功！",classesService.searchByPage(pageNo,pageSize,classesDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"分页模糊查询所有班级信息失败！");
        }

    }

    /**
     * 根据id修改班级信息
     * @param classesDTO 班级传输实体
     * @return Result
     */
    @ApiOperation("根据id修改班级信息")
    @PostMapping("/updateClasses")
    public Result updateClasses(@ApiParam("classesDTO") @RequestBody ClassesDTO classesDTO){
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
     * @param ids 班级id数组
     * @return Result
     */
    @ApiOperation("根据id删除班级信息")
    @PostMapping("/delectClasses")
    public Result delectClassesByIds(@ApiParam("ids") @RequestParam Long[] ids){
        try {
            classesService.deleteClassesByIds(ids);
            return new Result(StatusCode.OK,true,"删除班级信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.ERROR,false,"删除班级信息失败！");
        }
    }

    /**
     * 根据id查找一个班级信息
     * @return 班级信息
     */
    @ApiOperation("根据id查找一个班级信息")
    @GetMapping("/findOne")
    public Result findOne(@ApiParam("cid") @RequestParam Long cid){
        try {
            return new Result(StatusCode.OK,true,"查找一个班级信息成功！", classesService.findOne(cid));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(StatusCode.OK,true,"查找一个班级信息失败！");
        }
    }


}
