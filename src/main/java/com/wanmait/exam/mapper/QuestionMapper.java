package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 题目表 Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface QuestionMapper extends BaseMapper<Question> {

    int insert(Question question);
    List<Question> findAll();
    Question findById(Integer id);
}
