package com.wanmait.exam.manageController;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManageCommonControllerAdvice {
    @ExceptionHandler(JWTVerificationException.class)
    public AjaxResult processJWTVerificationException(JWTVerificationException e){
        return AjaxResult.error(10002,e.getMessage());
    }

}
