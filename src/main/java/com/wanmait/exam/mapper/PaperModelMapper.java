package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.PaperModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wanmait.exam.entity.QuestionType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface PaperModelMapper extends BaseMapper<PaperModel> {
    List<PaperModel> findByModelId(Integer modelId);
    PaperModel findByPaperModelId(Integer paperModelId);
    List<QuestionType> getExistTypes(Integer modelId);
}
