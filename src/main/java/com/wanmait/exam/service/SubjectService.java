package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学科表 服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface SubjectService extends IService<Subject> {

    PageInfo<Subject> findAll(int pageNum, int pageSize);

}
