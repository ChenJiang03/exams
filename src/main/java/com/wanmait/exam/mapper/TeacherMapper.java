package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 教师表 Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> selectList();
    Teacher findByUsernameAndPassword(Teacher teacher);
}
