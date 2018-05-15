package com.eappcat.starter.advise;

import com.eappcat.starter.base.Result;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {
        return new Result().setStatus(500).setMessage(ex.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = {AuthenticationServiceException.class,BadCredentialsException.class})
    public Result authenticationServiceException(){
        return new Result().setStatus(100).setMessage("登陆失败");
    }
}
