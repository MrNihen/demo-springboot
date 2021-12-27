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
     * @param classesDTO 班级传输实体
     */
    void add(ClassesDTO classesDTO);

    /**
     * 查询所有班级
     * @return List<ClassesVO>
     */
    List<ClassesVO> findAll();

    /**
     * 分页查询所有班级
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @return PageSelectDTO<ClassesVO>
     */
    PageSelectDTO<ClassesVO> findByPage(Integer pageNo, Integer pageSize);

    /**
     *  搜索带分页
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @param classesDTO 班级传输实体
     * @return PageSelectDTO<ClassesVO> 分页结果
     */
    PageSelectDTO<ClassesVO> searchByPage(Integer pageNo, Integer pageSize, ClassesDTO classesDTO);

    /**
     * 根据id修改班级信息
     * @param classesDTO 班级传输实体
     */
    void updateClasses(ClassesDTO classesDTO);

    /**
     * 根据id删除班级
     * @param ids 班级id数组
     */
    void deleteClassesByIds(Long[] ids);

    /**
     * 查找一个班级信息
     * @param cid 班级id
     * @return 班级视图实体
     */
    ClassesVO findOne(Long cid);
}
