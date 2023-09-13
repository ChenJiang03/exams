package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.PaperModel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wanmait.exam.entity.QuestionType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface PaperModelService extends IService<PaperModel> {
    PageInfo<PaperModel> findByModelId(Integer modelId,Integer pageNum,Integer pageSize);
    PaperModel findByPaperModelId(Integer paperModelId);
    List<QuestionType> getExistTypes(Integer modelId);
}
