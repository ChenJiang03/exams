package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Levels;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 难易程度表 服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface LevelsService extends IService<Levels> {

    List<Levels> findAll();

    PageInfo<Levels> findAll(int pageNum,int pageSize);

    void add(Levels levels);

    void update(Levels levels);

}
