package com.wanmait.exam.controller;

import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.service.LevelsService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 难易程度表 前端控制器
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@RestController
@RequestMapping("/manage/levels")
public class LevelsController {
    @Resource
    private LevelsService levelsService;

    @GetMapping("list")
    public AjaxResult list(){
        List<Levels> levelsList=levelsService.findAll();
        return AjaxResult.success(levelsList);
    }

    @PostMapping("add")
    public AjaxResult add(@RequestBody Levels levels){
        levelsService.add(levels);
        return AjaxResult.success("添加完成");
    }

    @GetMapping("update")
    public AjaxResult updateInfo(Integer id){
        Levels levels=levelsService.getById(id);
        return AjaxResult.success(levels);
    }

    @PostMapping("update")
    public AjaxResult update(@RequestBody Levels levels){
        levelsService.update(levels);
        return AjaxResult.success("修改完成");
    }

    @PostMapping("delete")
    public AjaxResult delete(Integer id) {
        levelsService.removeById(id);
        return AjaxResult.success("删除完成");
    }
}
