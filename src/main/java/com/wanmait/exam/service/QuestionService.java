package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 题目表 服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface QuestionService extends IService<Question> {
    int insert(Question question);
    PageInfo<Question> findAll(Integer pageNum);
    Question findById(Integer id);
    PageInfo<Question> search(Question question, Integer knowledge, Date startTime, Date endTime,Integer pageNum);
}
