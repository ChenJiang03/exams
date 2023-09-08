package com.wanmait.exam.manageController;

import com.wanmait.exam.service.SubjectService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/subject")
public class ManageSubjectController
{
    @Resource
    private SubjectService subjectService;

    @GetMapping("list")
    public AjaxResult selectList() {
        return AjaxResult.success(this.subjectService.list());
    }
}
