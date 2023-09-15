package com.wanmait.exam.controller;

import com.wanmait.exam.entity.Student;
import com.wanmait.exam.entity.Subject;
import com.wanmait.exam.service.StudentService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentService studentService;

    @PostMapping("register")
    public AjaxResult register(@RequestBody Student student){
        studentService.save(student);
        return AjaxResult.success("注册完成！");
    }

}
