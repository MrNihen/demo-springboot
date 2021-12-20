package com.nihen.springbootdemomybatisplus.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *  学生展示类
 * </p>
 *
 * @author admin
 * @since 2021-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生编号
     */
    @ApiModelProperty("学生编号")
    @TableId(value = "sid",type = IdType.INPUT)
    private Long sid;

    /**
     * 学生姓名
     */
    @ApiModelProperty("学生姓名")
    private String sname;

    /**
     * 学生性别
     */
    @ApiModelProperty("学生性别")
    private String sex;

    /**
     * 学生年龄
     */
    @ApiModelProperty("学生年龄")
    private Integer age;

    /**
     * 学生地址
     */
    @ApiModelProperty("学生地址")
    private String addr;

    /**
     * 所属班级
     */
    @ApiModelProperty("所属班级")
    private String cname;

}
