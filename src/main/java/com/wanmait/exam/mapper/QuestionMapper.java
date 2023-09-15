package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    List<Question> search(@Param("question") Question question, @Param("knowledge") Integer knowledge, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
