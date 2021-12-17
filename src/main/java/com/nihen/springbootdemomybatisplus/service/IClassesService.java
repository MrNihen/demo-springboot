package com.nihen.springbootdemomybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nihen.springbootdemomybatisplus.entity.dto.ClassesDTO;
import com.nihen.springbootdemomybatisplus.entity.po.Classes;
import com.nihen.springbootdemomybatisplus.entity.vo.ClassesVO;
import com.nihen.springbootdemomybatisplus.util.PageSelectDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
public interface IClassesService extends IService<Classes> {

    /**
     * 添加班级
     * @param classesDTO
     */
    void add(ClassesDTO classesDTO);

    /**
     * 查询所有班级
     * @return List<ClassesVO>
     */
    List<ClassesVO> findAll();

    /**
     * 分页查询所有班级
     * @param pageNo
     * @param pageSize
     * @return PageSelectDTO<ClassesVO>
     */
    PageSelectDTO<ClassesVO> findByPage(Integer pageNo, Integer pageSize);

    /**
     *  搜索带分页
     * @param pageNo
     * @param pageSize
     * @param classesDTO
     * @return PageSelectDTO<ClassesVO>
     */
    PageSelectDTO<ClassesVO> searchByPage(Integer pageNo, Integer pageSize, ClassesDTO classesDTO);

    /**
     * 根据id修改班级信息
     * @param classesDTO
     */
    void updateClasses(ClassesDTO classesDTO);

    /**
     * 根据id删除班级
     * @param ids
     */
    void delectClassesByIds(Long[] ids);

    /**
     * 查找一个班级信息
     * @return ClassesVO
     */
    ClassesVO findOne();
}
