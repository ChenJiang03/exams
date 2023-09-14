package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.QuestionType;
import com.wanmait.exam.mapper.QuestionTypeMapper;
import com.wanmait.exam.service.QuestionTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目类型表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionTypeServiceImpl extends ServiceImpl<QuestionTypeMapper, QuestionType> implements QuestionTypeService {

    @Resource
    private QuestionTypeMapper questionTypeMapper;
    @Override
    public List<QuestionType> getTypes() {
        return questionTypeMapper.getTypes();
    }
}
