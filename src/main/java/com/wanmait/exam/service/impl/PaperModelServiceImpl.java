package com.wanmait.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.PaperModel;
import com.wanmait.exam.entity.QuestionType;
import com.wanmait.exam.mapper.PaperModelMapper;
import com.wanmait.exam.service.ConfigService;
import com.wanmait.exam.service.PaperModelService;
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
public class PaperModelServiceImpl extends ServiceImpl<PaperModelMapper, PaperModel> implements PaperModelService {

    @Resource
    private PaperModelMapper paperModelMapper;
    @Resource
    private ConfigService configService;

    @Override
    public PageInfo<PaperModel> findByModelId(Integer modelId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PaperModel> paperModels=paperModelMapper.findByModelId(modelId);
        int navigatePage=Integer.parseInt(configService.selectConfigValueByConfigKey("paper_model_navigatePage"));
        return new PageInfo<>(paperModels,navigatePage);
    }

    @Override
    public PaperModel findByPaperModelId(Integer paperModelId) {
        return paperModelMapper.findByPaperModelId(paperModelId);
    }

    @Override
    public List<QuestionType> getExistTypes(Integer modelId) {
        return paperModelMapper.getExistTypes(modelId);
    }
}
