package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Levels;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 难易程度表 Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface LevelsMapper extends BaseMapper<Levels> {

    List<Levels> findAll();

    void add(Levels levels);

    void update(Levels levels);

}
