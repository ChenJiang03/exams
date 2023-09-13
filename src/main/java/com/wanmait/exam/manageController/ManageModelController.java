package com.wanmait.exam.manageController;


import com.wanmait.exam.entity.Model;
import com.wanmait.exam.service.ConfigService;
import com.wanmait.exam.service.ModelService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("manage/model")
public class ManageModelController {
    @Resource
    private ModelService modelService;
    @Resource
    private ConfigService configService;
    @GetMapping("list")
    public AjaxResult list(Integer pageNum){
        if(pageNum==null){
            pageNum=1;
        }
        int pageSize;
        try {
            pageSize=Integer.parseInt(configService.selectConfigValueByConfigKey("model_page_size"));
        } catch (NumberFormatException e) {
            pageSize=5;
        }
        return AjaxResult.success(modelService.findAll(pageNum,pageSize));
    }

    @PostMapping("delete")
    public AjaxResult delete(Integer id){
        return AjaxResult.success("删除成功",modelService.removeById(id));
    }

    @PostMapping("add")
    public AjaxResult add(@RequestBody Model model){
        return AjaxResult.success("添加成功",modelService.save(model));
    }
}
