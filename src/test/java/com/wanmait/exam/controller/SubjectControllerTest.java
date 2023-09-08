package com.wanmait.exam.controller;

import com.wanmait.exam.entity.Subject;
import com.wanmait.exam.manageController.ManageSubjectController;
import com.wanmait.exam.util.AjaxResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class SubjectControllerTest {
    @Resource
    ManageSubjectController manageSubjectController;

    @Test
    public void testlist(){
//        List<Subject> subjectList=manageSubjectController.subjectList();
//        subjectList.forEach(System.out::println);
    }

    @Test
    public void testfindById(){
//        Subject subject=manageSubjectController.updateInfo(1);
//        System.out.println(subject.getId());
//        System.out.println(subject.getTitle());
//        System.out.println(subject.getDescription());
//        System.out.println(subject.getStartTime());
//        System.out.println(subject.getEndTime());
    }

    @Test
    public void deleteTest(){
        manageSubjectController.delete(2);
    }


    @Test
    public void add(){
        Subject subject=new Subject();
        subject.setTitle("bbb");
        subject.setDescription("AAAAAAAAA");
        subject.setSort(5);
        Date startTime=new Date();
        subject.setStartTime(startTime);
        Date endTime=new Date();
        subject.setEndTime(endTime);
        manageSubjectController.add(subject);
    }

}
