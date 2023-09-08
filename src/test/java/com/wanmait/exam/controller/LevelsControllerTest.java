package com.wanmait.exam.controller;

import com.wanmait.exam.entity.Levels;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class LevelsControllerTest {
    @Resource
    LevelsController levelsController;

    @Test
    public void testUpdateInfo(){

        levelsController.delete(7);
    }
}
