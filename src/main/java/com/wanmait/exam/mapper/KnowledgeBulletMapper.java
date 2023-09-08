package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.KnowledgeBullet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 知识点表 Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface KnowledgeBulletMapper extends BaseMapper<KnowledgeBullet> {

    List<KnowledgeBullet> selectList();
}
