package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.KnowledgeQuestion;
import com.wanmait.exam.mapper.KnowledgeQuestionMapper;
import com.wanmait.exam.service.KnowledgeQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class KnowledgeQuestionServiceImpl extends ServiceImpl<KnowledgeQuestionMapper, KnowledgeQuestion> implements KnowledgeQuestionService {
    @Resource
    private KnowledgeQuestionMapper knowledgeQuestionMapper;

    @Override
    public List<KnowledgeQuestion> findById(Integer id) {
        return knowledgeQuestionMapper.findById(id);
    }
}
