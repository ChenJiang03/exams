package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface TeacherService extends IService<Teacher> {
    Teacher login(Teacher teacher);
    PageInfo<Teacher> findAll(int pageNum,int pageSize);
}
