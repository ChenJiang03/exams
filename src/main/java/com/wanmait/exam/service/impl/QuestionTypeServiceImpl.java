package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.QuestionType;
import com.wanmait.exam.mapper.QuestionTypeMapper;
import com.wanmait.exam.service.QuestionTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目类型表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class QuestionTypeServiceImpl extends ServiceImpl<QuestionTypeMapper, QuestionType> implements QuestionTypeService {

}
