package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.PaperModel;
import com.wanmait.exam.service.ConfigService;
import com.wanmait.exam.service.PaperModelService;
import com.wanmait.exam.service.QuestionTypeService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("manage/paperModel")
public class ManagePaperModelController {
    @Resource
    private PaperModelService paperModelService;
    @Resource
    private ConfigService configService;
    @Resource
    private QuestionTypeService questionTypeService;
    @PostMapping("delete")
    public AjaxResult delete(Integer id){
        return AjaxResult.success("删除成功",paperModelService.removeById(id));
    }

    @PostMapping("add")
    public AjaxResult addPaperModel(@RequestBody PaperModel paperModel){
        System.out.println(paperModel);
        paperModelService.save(paperModel);
        return AjaxResult.success("添加成功");
    }

    @GetMapping("select")
    public AjaxResult selectByModelId(Integer id,Integer pageNum){
        if(pageNum==null){
            pageNum=1;
        }
        int pageSize;
        try {
            pageSize=Integer.parseInt(configService.selectConfigValueByConfigKey("paper_model_page_size"));
        } catch (NumberFormatException e) {
            pageSize=6;
        }
        return AjaxResult.success(paperModelService.findByModelId(id,pageNum,pageSize));
    }

    @GetMapping("find")
    public AjaxResult findByPaperModelId(Integer id){
        return AjaxResult.success(paperModelService.findByPaperModelId(id));
    }

    @PostMapping("update")
    public AjaxResult updatePaperModel(@RequestBody PaperModel paperModel){
        paperModelService.updateById(paperModel);
        return AjaxResult.success("修改成功");
    }

    @GetMapping("getExistTypes")
    public AjaxResult getExistTypes(Integer id){
        return AjaxResult.success(paperModelService.getExistTypes(id));
    }

    @GetMapping("getTypes")
    public AjaxResult getTypes(Integer id){
        return AjaxResult.success(questionTypeService.getTypes()).put("existTypes",paperModelService.getExistTypes(id));
    }
}
