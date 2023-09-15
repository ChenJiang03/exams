package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.QuestionType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 题目类型表 Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface QuestionTypeMapper extends BaseMapper<QuestionType> {
    List<QuestionType> getTypes();
}
