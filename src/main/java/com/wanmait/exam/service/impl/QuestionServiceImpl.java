package com.wanmait.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Question;
import com.wanmait.exam.mapper.QuestionMapper;
import com.wanmait.exam.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 题目表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;
    @Override
    public int insert(Question question) {
        return questionMapper.insert(question);
    }

    @Override
    public PageInfo<Question> findAll(Integer pageNum) {
        Integer pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questionList = questionMapper.findAll();
        PageInfo<Question> questionPageInfo = new PageInfo<>(questionList,3);
        return questionPageInfo;
    }

    @Override
    public Question findById(Integer id) {
        return questionMapper.findById(id);
    }

    @Override
    public PageInfo<Question> search(Question question, Integer knowledge, Date startTime, Date endTime,Integer pageNum) {
        int pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<Question> questionList = questionMapper.search(question, knowledge, startTime, endTime);
        PageInfo<Question> questionPageInfo = new PageInfo<>(questionList,3);
        return questionPageInfo;
    }
}
