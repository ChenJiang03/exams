package com.wanmait.exam.service;

import com.wanmait.exam.entity.QuestionType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目类型表 服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface QuestionTypeService extends IService<QuestionType> {
    List<QuestionType> getTypes();
}
