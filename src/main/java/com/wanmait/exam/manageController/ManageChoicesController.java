package com.wanmait.exam.manageController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanmait.exam.entity.Choices;
import com.wanmait.exam.service.ChoicesService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manage/choices")
public class ManageChoicesController {
    @Resource
    private ChoicesService choicesService;

    @PostMapping("add")
    public AjaxResult add(@RequestBody Object[] choicesList,String id){
        Integer newId = Integer.parseInt(id);

        // 将LinkedHashMap转换为Java对象
        for(int i = 0;i < choicesList.length;i++){
            ObjectMapper objectMapper = new ObjectMapper();
            Choices choices = objectMapper.convertValue(choicesList[i],Choices.class);
            choices.setQuestionId(newId);
            choicesService.save(choices);
        }
        return AjaxResult.success("添加成功");
    }

    @PostMapping("choicesAdd")
    public AjaxResult choicesAdd(@RequestBody Choices choices, String id){
        Integer newId = Integer.parseInt(id);
        choices.setQuestionId(newId);
        choicesService.save(choices);
        return AjaxResult.success("添加成功");
    }

    @GetMapping("findById")
    public AjaxResult findById(Integer id){
        LambdaQueryWrapper<Choices> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Choices::getQuestionId,id);
        return AjaxResult.success(choicesService.list(queryWrapper));
    }

    @PostMapping("update")
    public AjaxResult update(@RequestBody Object[] choicesList){
        for (Object o : choicesList) {
            ObjectMapper objectMapper = new ObjectMapper();
            Choices choices = objectMapper.convertValue(o,Choices.class);
            LambdaUpdateWrapper<Choices> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(Choices::getId,choices.getId());
            choicesService.update(choices,updateWrapper);
        }

        return AjaxResult.success("修改成功");
    }
}
