package com.wanmait.exam.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SubjectServiceTest
{
    @Resource
    private SubjectService subjectService;

    @Test
    public void testSelectList() {
        System.out.println(this.subjectService.list());
    }
}
