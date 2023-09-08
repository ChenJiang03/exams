package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.Teacher;
import com.wanmait.exam.mapper.TeacherMapper;
import com.wanmait.exam.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 教师表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public Teacher login(Teacher teacher) {
        if(!StringUtils.hasText(teacher.getUsername())){
            return null;
        }
        if(!StringUtils.hasText(teacher.getPassword())){
            return null;
        }
        Teacher loginTeacher=teacherMapper.findByUsernameAndPassword(teacher);
        return loginTeacher;
    }
}
