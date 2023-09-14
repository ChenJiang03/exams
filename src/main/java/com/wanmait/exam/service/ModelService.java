package com.wanmait.exam.service;

import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Model;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface ModelService extends IService<Model> {
   PageInfo<Model> findAll(int pageNum,int pageSize);
    Model findById(Integer id);
}
