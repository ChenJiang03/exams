package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.KnowledgeBullet;
import com.wanmait.exam.service.KnowledgeBulletService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
