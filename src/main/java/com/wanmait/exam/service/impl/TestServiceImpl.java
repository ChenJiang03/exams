package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.Test;
import com.wanmait.exam.mapper.TestMapper;
import com.wanmait.exam.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
