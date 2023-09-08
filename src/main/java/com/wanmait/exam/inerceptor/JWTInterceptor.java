package com.wanmait.exam.inerceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wanmait.exam.entity.Teacher;
import com.wanmait.exam.service.TeacherService;

import com.wanmait.exam.util.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Resource
    private TeacherService teacherService;

    //如果返回true就调用控制器的功能处理方法，如果返回false就不调用，如果前后端不分离一般配合重定向，如果前后端分离，就给客户端返回响应数据
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查是否是预检请求，如果是预检请求放行
        if("OPTIONS".equals(request.getMethod())){
            return true;
        }
        //获得token
        String token= request.getHeader("token");
        if(token==null){
            //走统一的异常处理CommonControllerAdvice的processJWTVerificationException方法
            throw new JWTVerificationException("请求没有携带token");
        }
        //获得签发对象,如果解析失败也会走统一的异常处理
        Integer id=null;
        try {
            id=Integer.parseInt(JWTUtils.getAudience(token));
        } catch (NumberFormatException e) {
            throw new JWTVerificationException("解析token失败");
        }
        //查询出教师
        Teacher teacher=teacherService.getById(id);
        if(teacher==null){
            throw new JWTVerificationException("没有查询到教师信息");
        }
        //验证token
        JWTUtils.verifyToken(token,teacher.getPassword());
        //给handler功能处理方法共享teacher对象
        request.setAttribute("teacher",teacher);
        return true;
    }
}
