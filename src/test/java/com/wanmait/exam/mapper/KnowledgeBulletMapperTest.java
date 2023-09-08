package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.KnowledgeBullet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class KnowledgeBulletMapperTest
{
    @Resource
    private KnowledgeBulletMapper knowledgeBulletMapper;

    @Test
    public void testSelectList()
    {
        knowledgeBulletMapper.selectList().forEach(System.out::println);
        List<KnowledgeBullet> knowledgeBullets = knowledgeBulletMapper.selectList();
        System.out.println(knowledgeBullets);
    }
}
