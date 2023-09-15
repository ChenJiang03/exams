package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.StudentClass;
import com.wanmait.exam.mapper.StudentClassMapper;
import com.wanmait.exam.service.StudentClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 关联学生班级表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-09-08
 */
@Service
public class StudentClassServiceImpl extends ServiceImpl<StudentClassMapper, StudentClass> implements StudentClassService {

}
