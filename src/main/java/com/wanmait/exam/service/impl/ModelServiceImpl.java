package com.wanmait.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Model;
import com.wanmait.exam.entity.PaperModel;
import com.wanmait.exam.mapper.ModelMapper;
import com.wanmait.exam.service.ConfigService;
import com.wanmait.exam.service.ModelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional(rollbackFor = Exception.class)
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements ModelService {
    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ConfigService configService;
    @Override
    public PageInfo<Model> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Model> modelList=modelMapper.selectList();
        int navigatePage=Integer.parseInt(configService.selectConfigValueByConfigKey("model_navigatePage"));
        return new PageInfo<>(modelList,navigatePage);
    }


    @Override
    public Model findById(Integer id) {
        return modelMapper.findById(id);
    }

}
