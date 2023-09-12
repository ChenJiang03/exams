package com.wanmait.exam.service;

import com.wanmait.exam.entity.KnowledgeQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface KnowledgeQuestionService extends IService<KnowledgeQuestion> {
    List<KnowledgeQuestion> findById(Integer id);
}
