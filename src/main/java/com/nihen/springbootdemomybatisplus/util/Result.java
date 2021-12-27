package com.nihen.springbootdemomybatisplus.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果集
 * @author zhuguanglong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * // 返回码
     */
    private Integer code;
    /**
     * //是否成功
     */
    private boolean flag;
    /**
     * //返回信息
     */
    private String message;
    /**
     * // 返回数据
     */
    private Object data;
    public Result(Integer code, boolean flag, String message){
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
