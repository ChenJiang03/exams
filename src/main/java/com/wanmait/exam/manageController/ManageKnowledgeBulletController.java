package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.KnowledgeBullet;
import com.wanmait.exam.service.KnowledgeBulletService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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

    /*
        * @Author Chen Jiang
        * @Description
        *    根据id查询知识点
        * @Date 2023/8/29 10:25
        * @Param [id]：知识点id
     */
    @GetMapping("findById")
    public AjaxResult findById(Integer id) {
        return AjaxResult.success(this.knowledgeBulletService.getById(id));
    }

    /*
        * @Author Chen Jiang
        * @Description
        *    添加知识点
        * @Date 2023/8/29 10:25
        * @Param [knowledgeBullet]：知识点实体类
     */
    @PostMapping("add")
    public AjaxResult add(@RequestBody KnowledgeBullet knowledgeBullet) {
        this.knowledgeBulletService.save(knowledgeBullet);
        return AjaxResult.success("添加成功");
    }

    /*
        * @Author Chen Jiang
        * @Description
        *    根据id删除知识点
        * @Date 2023/8/29 10:25
        * @Param [id]：知识点id
     */
    @GetMapping("delete")
    public AjaxResult deleteById(Integer id) {
        this.knowledgeBulletService.deleteById(id);
        return AjaxResult.success("删除成功");
    }

    /*
        * @Author Chen Jiang
        * @Description
        *    修改知识点，传进去的知识点只修改它的非空属性
        * @Date 2023/9/8 13:25
        * @Param [knowledgeBullet]：知识点实体类
     */
    @PostMapping("update")
    public AjaxResult updateById(@RequestBody KnowledgeBullet knowledgeBullet) {
        Date date = new Date();
        knowledgeBullet.setUpdateTime(date);
        knowledgeBulletService.updateById(knowledgeBullet);
        return AjaxResult.success("修改成功");
    }
}
