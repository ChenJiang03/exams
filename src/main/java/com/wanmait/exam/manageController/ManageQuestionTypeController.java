package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.QuestionType;
import com.wanmait.exam.service.QuestionTypeService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/questionType")
public class ManageQuestionTypeController {

    @Resource
    private QuestionTypeService questionTypeService;

    @GetMapping("list")
    public AjaxResult list(){
        return AjaxResult.success(questionTypeService.list());
    }

    @PostMapping("add")
    public AjaxResult add(@RequestBody QuestionType questionType){
        questionTypeService.save(questionType);
        return AjaxResult.success("添加成功");
    }

    @GetMapping("delete")
    public AjaxResult delete(Integer id){
        questionTypeService.removeById(id);
        return AjaxResult.success("删除成功");
    }

    @GetMapping("findById")
    public AjaxResult findById(String id){
        Integer newId = Integer.parseInt(id);
        return AjaxResult.success(questionTypeService.getById(newId));
    }

    @PostMapping("update")
    public AjaxResult update(@RequestBody QuestionType questionType){
        return AjaxResult.success("修改成功",questionTypeService.updateById(questionType));
    }
}
