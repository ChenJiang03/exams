package com.wanmait.exam.manageController;

import com.wanmait.exam.entity.KnowledgeQuestion;
import com.wanmait.exam.service.KnowledgeQuestionService;
import com.wanmait.exam.util.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manage/knowledgeQuestion")
public class ManageKnowledgeQuestionController {

    @Resource
    private KnowledgeQuestionService knowledgeQuestionService;

    @GetMapping("findById")
    public AjaxResult findById(Integer id){
        List<KnowledgeQuestion> knowledgeQuestionList = knowledgeQuestionService.findById(id);
        List<Integer> list = new ArrayList<>();
        for (KnowledgeQuestion knowledgeQuestion : knowledgeQuestionList) {
            list.add(knowledgeQuestion.getKnowledgeId());
        }
        return AjaxResult.success(knowledgeQuestionService.findById(id)).put("list",list);
    }
}
