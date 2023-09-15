package com.wanmait.exam.manageController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.wanmait.exam.entity.*;
import com.wanmait.exam.service.ChoicesService;
import com.wanmait.exam.service.KnowledgeBulletService;
import com.wanmait.exam.service.KnowledgeQuestionService;
import com.wanmait.exam.service.QuestionService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/manage/question")
@Transactional(rollbackFor = Exception.class)
public class ManageQuestionController {
    @Resource
    private QuestionService questionService;
    @Resource
    private KnowledgeQuestionService knowledgeQuestionService;

    @PostMapping("add")
    public AjaxResult add(@RequestBody Question question, String knowledge, HttpServletRequest request){
        Subject subject = new Subject();
        subject.setId(1);
        question.setSubject(subject);
        Teacher teacher = (Teacher) request.getAttribute("teacher");
        question.setTeacher(teacher);
        questionService.insert(question);
        String[] array = knowledge.split(",");
        for(int i = 0;i < array.length;i++){
            KnowledgeQuestion knowledgeQuestion = new KnowledgeQuestion();
            knowledgeQuestion.setQuestionId(question.getId());
            knowledgeQuestion.setKnowledgeId(Integer.parseInt(array[i]));
            knowledgeQuestionService.save(knowledgeQuestion);
        }
        return AjaxResult.success("添加成功").put("id",question.getId());
    }

    @GetMapping("list")
    public AjaxResult list(Integer pageNum){
        if(pageNum == null){
            pageNum = 1;
        }
        return AjaxResult.success(questionService.findAll(pageNum));
    }

    @GetMapping("delete")
    public AjaxResult delete(Integer id){
        questionService.removeById(id);
        return AjaxResult.success("删除成功");
    }

    @GetMapping("findById")
    public AjaxResult findById(Integer id){
        return AjaxResult.success(questionService.getById(id));
    }

    @PostMapping("update")
    public AjaxResult update(@RequestBody Question question,String knowledge){
        question.setUpdateTime(new Date());
        LambdaUpdateWrapper<Question> questionLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        questionLambdaUpdateWrapper.eq(Question::getId,question.getId());
        LambdaQueryWrapper<KnowledgeQuestion> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(KnowledgeQuestion::getQuestionId,question.getId());
        questionService.update(question,questionLambdaUpdateWrapper);
        knowledgeQuestionService.remove(queryWrapper);
        String[] array = knowledge.split(",");
        for (String s : array) {
            KnowledgeQuestion knowledgeQuestion = new KnowledgeQuestion();
            knowledgeQuestion.setQuestionId(question.getId());
            knowledgeQuestion.setKnowledgeId(Integer.parseInt(s));
            knowledgeQuestionService.save(knowledgeQuestion);
        }
        return AjaxResult.success("更新");
    }

    @PostMapping("search")
    public AjaxResult search(@RequestBody Question question,Integer knowledge,Date startTime,Date endTime,Integer pageNum){
        if(pageNum == null){
            pageNum = 1;
        }
        return AjaxResult.success(questionService.search(question, knowledge, startTime, endTime,pageNum));
    }
}
