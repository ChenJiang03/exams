package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.KnowledgeBullet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 知识点表 服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface KnowledgeBulletService extends IService<KnowledgeBullet> {

    PageInfo<KnowledgeBullet> findAll(Integer pageNum);

    void deleteById(Integer id);

}
