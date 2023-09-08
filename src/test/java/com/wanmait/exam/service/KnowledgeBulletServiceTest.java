package com.wanmait.exam.service;

import com.wanmait.exam.entity.KnowledgeBullet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class KnowledgeBulletServiceTest
{
    @Resource
    private KnowledgeBulletService knowledgeBulletService;

    @Test
    public void testFindAll()
    {
        System.out.println(knowledgeBulletService.findAll(2).getList());
    }

    @Test
    public void testFindById()
    {
        System.out.println(knowledgeBulletService.getById(10));
    }

    @Test
    public void testUpdateById()
    {
        KnowledgeBullet knowledgeBullet = new KnowledgeBullet();
        knowledgeBullet.setId(17);
//        knowledgeBullet.setKnowledgePoint("测试修改知识点");
        knowledgeBullet.setSubjectId(6);
        knowledgeBulletService.updateById(knowledgeBullet);
    }

    @Test
    public void testDeleteById()
    {
        knowledgeBulletService.deleteById(1);
    }

    @Test
    public void testInsert()
    {
        KnowledgeBullet knowledgeBullet = new KnowledgeBullet();
        knowledgeBullet.setKnowledgePoint("测试知识点");
        knowledgeBullet.setSubjectId(1);
        knowledgeBulletService.save(knowledgeBullet);
    }

    @Test
    public void testDate()
    {
        Date date = new Date();
        System.out.println(date);
    }
}
