package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.entity.Subject;
import com.wanmait.exam.service.SubjectService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("manage/subject")
public class ManageSubjectController {
    @Resource
    SubjectService subjectService;

    @GetMapping("list")
    public AjaxResult subjectList(Integer pageNum){
        if(pageNum==null){
            pageNum=1;
        }
        int pageSize=3;

        return AjaxResult.success(subjectService.findAll(pageNum,pageSize));
    }

    @GetMapping("update")
    public AjaxResult updateInfo(Integer id){
        Subject subject=subjectService.getById(id);
        return AjaxResult.success(subject);
    }

    @PostMapping("update")
    public AjaxResult update(@RequestBody Subject subject){
        if(subject.getIsCompleted().equals(false)){
            subject.setEndTime(null);
            subjectService.updateById(subject);
            return AjaxResult.success("修改完成");
        }
        else{
            subject.setEndTime(new Date());
            subjectService.updateById(subject);
            return AjaxResult.success("修改完成");
        }

    }

    @PostMapping("delete")
    public AjaxResult delete(Integer id){
        subjectService.removeById(id);
        return AjaxResult.success("删除完成");
    }

    @PostMapping("add")
    public AjaxResult add(@RequestBody Subject subject){
        subjectService.save(subject);
        return AjaxResult.success("添加完成");
    }

}
