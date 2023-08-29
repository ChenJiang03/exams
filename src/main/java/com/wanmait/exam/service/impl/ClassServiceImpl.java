package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.Class;
import com.wanmait.exam.mapper.ClassMapper;
import com.wanmait.exam.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

}
