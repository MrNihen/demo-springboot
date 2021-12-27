package com.nihen.springbootdemomybatisplus.util;

import lombok.Data;

import java.util.List;

/**
 * 分页结果
 * @author admin
 */
@Data
public class PageSelectDTO<T> {
    /**
     * 当前页
     */
    private Integer pageNo;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long pageTotal;

    /**
     * 列表
     */
    private List<T> list;
}
