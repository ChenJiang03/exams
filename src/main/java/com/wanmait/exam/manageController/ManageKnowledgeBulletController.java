package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.KnowledgeBullet;
import com.wanmait.exam.service.KnowledgeBulletService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/knowledgeBullet")
public class ManageKnowledgeBulletController
{
    @Resource
    private KnowledgeBulletService knowledgeBulletService;

    /*
        * @Author Chen Jiang
        * @Description
        *    知识点列表
        * @Date 2023/8/29 10:25
        * @Param [pageNum]：页码
     */
    @GetMapping("list")
    public AjaxResult selectList(Integer pageNum) {
        if(pageNum == null)
        {
            pageNum = 1;
        }
        return AjaxResult.success(this.knowledgeBulletService.findAll(pageNum));
    }

    @GetMapping("select")
    public AjaxResult selectById(Integer id) {
        return AjaxResult.success(this.knowledgeBulletService.getById(id));
    }

    @PostMapping("add")
    public AjaxResult add(@RequestBody KnowledgeBullet knowledgeBullet) {
        this.knowledgeBulletService.save(knowledgeBullet);
        return AjaxResult.success("添加成功");
    }

    @GetMapping("delete")
    public AjaxResult deleteById(Integer id) {
        this.knowledgeBulletService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    @GetMapping("update")
    public AjaxResult updateById(@RequestBody KnowledgeBullet knowledgeBullet) {
        knowledgeBulletService.updateById(knowledgeBullet);
        return AjaxResult.success("修改成功");
    }
}
