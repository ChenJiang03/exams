package com.wanmait.exam.controller;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.entity.Student;
import com.wanmait.exam.service.LevelsService;
import com.wanmait.exam.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class LevelsControllerTest {
    @Resource
    LevelsController levelsController;

    @Resource
    LevelsService levelsService;

    @Resource
    StudentController studentController;

    @Test
    public void testUpdateInfo(){
        Student student=new Student();

        student.setUsername("123456789").setPassword("987654321").setPhone("135161616").setName("哈哈哈");
        studentController.register(student);

    }
}
