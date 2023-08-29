package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.Student;
import com.wanmait.exam.mapper.StudentMapper;
import com.wanmait.exam.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
