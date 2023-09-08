package com.wanmait.exam.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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
    public void testDeleteById()
    {
        knowledgeBulletService.deleteById(1);
    }
}
