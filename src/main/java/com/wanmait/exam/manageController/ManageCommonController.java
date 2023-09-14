package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.Teacher;
import com.wanmait.exam.service.TeacherService;
import com.wanmait.exam.util.AjaxResult;
import com.wanmait.exam.util.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class ManageCommonController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Value("${token.expiresMinutes}")
    private int expiresMinutes;

    @PostMapping("manage/login")
    public AjaxResult login(@RequestBody Teacher teacher, HttpServletRequest request){
        Teacher loginTeacher=teacherService.login(teacher);
        if(loginTeacher!=null){
            Map<String,String> claims=new HashMap<>();
            claims.put("username",loginTeacher.getUsername());
            claims.put("name",loginTeacher.getName());
            String token= JWTUtils.createToken(loginTeacher.getId().toString(),expiresMinutes,loginTeacher.getPassword(),claims);
            //以token字符串为键，teacher对象为值，保存在redis中
            redisTemplate.opsForValue().set("token:"+token,teacher,expiresMinutes, TimeUnit.MINUTES);
            loginTeacher.setPassword(null);
            return AjaxResult.success("登录成功").put("token",token).put("teacher",loginTeacher);
        }
        return AjaxResult.error(10001,"登陆失败");
    }
}
