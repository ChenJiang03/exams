package com.wanmait.exam.service;

import com.wanmait.exam.entity.Levels;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class LevelsServiceTest {
    @Resource
    private LevelsService levelsService;

    @Test
    public void testUpdate(){
        Levels levels=new Levels();
        levels.setId(7).setScore(15).setLevel("天堂");
        levelsService.update(levels);

        List<Levels> levelsList=levelsService.findAll();
        levelsList.forEach(System.out::println);
    }

}
