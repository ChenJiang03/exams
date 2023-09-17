package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 学科表 Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    List<Subject> findAll();

}
