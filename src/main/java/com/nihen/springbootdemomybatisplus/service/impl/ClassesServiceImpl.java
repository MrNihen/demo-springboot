package com.nihen.springbootdemomybatisplus.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nihen.springbootdemomybatisplus.entity.dto.ClassesDTO;
import com.nihen.springbootdemomybatisplus.entity.po.Classes;
import com.nihen.springbootdemomybatisplus.entity.vo.ClassesVO;
import com.nihen.springbootdemomybatisplus.mapper.ClassesMapper;
import com.nihen.springbootdemomybatisplus.service.IClassesService;
import com.nihen.springbootdemomybatisplus.util.PageSelectDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  班级服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@Log4j2
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements IClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public void add(ClassesDTO classesDTO) {
        log.info("add start ClassesDTO ={}",classesDTO);
        Classes classes = new Classes();
        classes.setCid(IdUtil.getSnowflake(0,1).nextId());
        classes.setCname(classesDTO.getCname());
        classesMapper.insert(classes);
    }

    @Override
    public List<ClassesVO> findAll() {
        List<ClassesVO> classesVOList = new ArrayList<>();
        List<Classes> classesList = classesMapper.selectList(null);
        for (Classes classes : classesList){
            ClassesVO classesVO = new ClassesVO();
           classesVO.setCid(classes.getCid());
           classesVO.setCname(classes.getCname());
           classesVOList.add(classesVO);
        }
        log.info("findAll start classesVOList ={}",classesVOList);
        return classesVOList;
    }

    @Override
    public PageSelectDTO<ClassesVO> findByPage(Integer pageNo, Integer pageSize) {
        log.info("findByPage from pageNo ={},pageSize ={}",pageNo,pageSize);
        //新建分页结果对象
        PageSelectDTO<ClassesVO> classesVOPageSelectDTO = new PageSelectDTO<>();
        //构造分页对象
        IPage<Classes> classesIPage = new Page<>(pageNo,pageSize);
        //开始分页
        classesMapper.selectPage(classesIPage,null);
        //当前页
        classesVOPageSelectDTO.setPageNo((int) classesIPage.getCurrent());
        //每页大小
        classesVOPageSelectDTO.setPageSize((int) classesIPage.getSize());
        //总记录数
        classesVOPageSelectDTO.setPageTotal(classesIPage.getTotal());
        //新建返回的ClassesVO列表集合
        List<ClassesVO> classesVOList = new ArrayList<>();
        //遍历分页Classes集合
        for (Classes classes : classesIPage.getRecords()){
            //新建classesVO对象
            ClassesVO classesVO = new ClassesVO();
            //构造返回对象
            classesVO.setCid(classes.getCid());
            classesVO.setCname(classes.getCname());
            log.info("findByPage start classesVO ={}",classesVO);
            //把返回对象放到返回集合中
            classesVOList.add(classesVO);
            log.info("findByPage start classesVOList ={}",classesVOList);
        }
        //把返回集合放在返回结果对象中
        classesVOPageSelectDTO.setList(classesVOList);
        //返回结果对象
        return classesVOPageSelectDTO;
    }

    @Override
    public PageSelectDTO<ClassesVO> searchByPage(Integer pageNo, Integer pageSize, ClassesDTO classesDTO) {

        log.info("searchByPage from pageNo ={},pageSize ={},ClassesDTO ={}",pageNo,pageSize,classesDTO);
        //新建分页结果对象
        PageSelectDTO<ClassesVO> classesVOPageSelectDTO = new PageSelectDTO<>();
        //构造搜索条件 like(Classes::getCname,classesDTO.getCname()
        LambdaQueryWrapper<Classes> classesLambdaQueryWrapper = Wrappers.lambdaQuery();
        classesLambdaQueryWrapper.eq(Classes::getCid,classesDTO.getCid()).or().eq(Classes::getCname,classesDTO.getCname());
        //构造分页对象
        IPage<Classes> classesIPage = new Page<>(pageNo,pageSize);
        //开始分页
        classesMapper.selectPage(classesIPage,classesLambdaQueryWrapper);
        //当前页
        classesVOPageSelectDTO.setPageNo((int) classesIPage.getCurrent());
        //每页大小
        classesVOPageSelectDTO.setPageSize((int) classesIPage.getSize());
        //总记录数
        classesVOPageSelectDTO.setPageTotal(classesIPage.getTotal());
        //新建返回的ClassesVO列表集合
        List<ClassesVO> classesVOList = new ArrayList<>();
        //遍历分页Classes集合
        for (Classes classes : classesIPage.getRecords()){
            //新建classesVO对象
            ClassesVO classesVO = new ClassesVO();
            //构造返回对象
            classesVO.setCid(classes.getCid());
            classesVO.setCname(classes.getCname());
            //把返回对象放到返回集合中
            classesVOList.add(classesVO);
        }
        //把返回集合放在返回结果对象中
        classesVOPageSelectDTO.setList(classesVOList);
        log.info("searchByPage start classesVOList ={}",classesVOList);
        //返回结果对象
        return classesVOPageSelectDTO;
    }

    /**
     * 修改班级
     * @param classesDTO
     */
    @Override
    public void updateClasses(ClassesDTO classesDTO) {
        Classes classes = new Classes();
        classes.setCid(classesDTO.getCid());
        classes.setCname(classesDTO.getCname());
        classesMapper.updateById(classes);
    }

    /**
     * 根据ID删除班级信息
     * @param ids
     */
    @Override
    public void delectClassesByIds(Long[] ids) {
        log.info("delectClassesByIds start ids ={}",ids);
        //高效数组转list集合
        ArrayList<Long> longList = new ArrayList<>(ids.length);
        Collections.addAll(longList,ids);
        classesMapper.deleteBatchIds(longList);
    }

    /**
     * 查找一个班级信息
     * @return
     */
    @Override
    public ClassesVO findOne(Long cid) {
        //构造搜索条件
        LambdaQueryWrapper<Classes> classesLambdaQueryWrapper = Wrappers.lambdaQuery();
        classesLambdaQueryWrapper.eq(Classes::getCid,cid);
        Classes classes = classesMapper.selectOne(classesLambdaQueryWrapper);
        ClassesVO classesVO = new ClassesVO();
        classesVO.setCid(classes.getCid());
        classesVO.setCname(classes.getCname());
        return classesVO;
    }


}
