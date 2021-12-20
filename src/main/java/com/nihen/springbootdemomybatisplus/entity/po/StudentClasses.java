package com.nihen.springbootdemomybatisplus.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *   班级和学生关联类
 *
 * </p>
 *
 * @author admin
 * @since 2021-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentClasses implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    /**
     * 班级id
     */
    @ApiModelProperty("班级id")
    private Long cid;

    /**
     * 学生id
     */
    @ApiModelProperty("学生id")
    private Long sid;


}
