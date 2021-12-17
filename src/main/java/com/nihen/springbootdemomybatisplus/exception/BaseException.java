package com.nihen.springbootdemomybatisplus.exception;

import com.nihen.springbootdemomybatisplus.util.Result;
import com.nihen.springbootdemomybatisplus.util.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 统一异常处理
 * @Author zhuguanglong
 * @Company
 * @Date 2021/12/12 22:26
 */
@ControllerAdvice
public class BaseException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(StatusCode.ERROR,false,e.getMessage());
    }
}
