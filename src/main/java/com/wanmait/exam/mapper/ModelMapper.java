package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Model;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface ModelMapper extends BaseMapper<Model> {
    List<Model> selectList();
    Model findById(Integer id);
}
