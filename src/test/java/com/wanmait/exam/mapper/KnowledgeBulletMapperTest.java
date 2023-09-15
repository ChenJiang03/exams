package com.wanmait.exam.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wanmait.exam.entity.KnowledgeBullet;
import com.wanmait.exam.service.KnowledgeBulletService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class KnowledgeBulletMapperTest
{
    @Resource
    private KnowledgeBulletMapper knowledgeBulletMapper;
    @Resource
    private KnowledgeBulletService knowledgeBulletService;

    @Test
    public void testSelectList()
    {
        knowledgeBulletMapper.selectList().forEach(System.out::println);
        List<KnowledgeBullet> knowledgeBullets = knowledgeBulletMapper.selectList();
        System.out.println(knowledgeBullets);
    }

    @Test
    public void list(){
        List<KnowledgeBullet> knowledgeBulletList = knowledgeBulletService.findAllById(1);
        knowledgeBulletList.forEach(System.out::println);
    }
}
