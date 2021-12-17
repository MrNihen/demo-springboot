package com.nihen.springbootdemomybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nihen.springbootdemomybatisplus.entity.po.StudentClasses;
import com.nihen.springbootdemomybatisplus.mapper.StudentClassesMapper;
import com.nihen.springbootdemomybatisplus.service.IStudentClassesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-12-17
 */
@Service
public class StudentClassesServiceImpl extends ServiceImpl<StudentClassesMapper, StudentClasses> implements IStudentClassesService {

}
