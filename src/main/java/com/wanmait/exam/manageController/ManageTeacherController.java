package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.Teacher;
import com.wanmait.exam.service.TeacherService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 教师表 前端控制器
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@RestController
@RequestMapping("/manage/teacher")
public class ManageTeacherController {
    @Resource
    private TeacherService teacherService;

    @GetMapping("list")
    public AjaxResult selectList(){
        List<Teacher> teacherList=teacherService.list();
        return AjaxResult.success(teacherList);
    }

    @PostMapping("add")
    public AjaxResult addTeacher(@RequestBody Teacher teacher){
        teacherService.save(teacher);
        return AjaxResult.success("添加成功");
    }

    @PostMapping("delete")
    public AjaxResult deleteTeacher(Integer id){
        teacherService.removeById(id);
        return AjaxResult.success("删除成功");
    }

    @GetMapping("select")
    public AjaxResult selectById(String id){
        int newId = Integer.parseInt(id);
        return AjaxResult.success(teacherService.getById(newId));
    }

    @PostMapping("update")
    public AjaxResult updateTeacherById(@RequestBody Teacher teacher){
        teacherService.updateById(teacher);
        return AjaxResult.success("修改成功");
    }
}
