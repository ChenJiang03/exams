package com.wanmait.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.mapper.LevelsMapper;
import com.wanmait.exam.service.LevelsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 难易程度表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LevelsServiceImpl extends ServiceImpl<LevelsMapper, Levels> implements LevelsService {

    @Resource
    private LevelsMapper levelsMapper;

    @Override
    public List<Levels> findAll() {

        return levelsMapper.findAll();
    }

    @Override
    public PageInfo<Levels> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Levels> levelsList=levelsMapper.findAll();
        return new PageInfo<>(levelsList,5);
    }

    @Override
    public void add(Levels levels) {
        levelsMapper.add(levels);
    }

    @Override
    public void update(Levels levels) {
        levelsMapper.update(levels);
    }
}
