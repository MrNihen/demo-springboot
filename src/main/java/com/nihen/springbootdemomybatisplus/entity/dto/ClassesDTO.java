package com.nihen.springbootdemomybatisplus.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClassesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级编号
     */
    private Long cid;

    /**
     * 班级名称
     */
    private String cname;


}
