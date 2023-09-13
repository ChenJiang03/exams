package com.wanmait.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Config;
import com.wanmait.exam.entity.Teacher;
import com.wanmait.exam.mapper.TeacherMapper;
import com.wanmait.exam.service.ConfigService;
import com.wanmait.exam.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private ConfigService configService;
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

    @Override
    public PageInfo<Teacher> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teacherList =teacherMapper.selectList();
        int navigatePage=Integer.parseInt(configService.selectConfigValueByConfigKey("teacher_navigatePage"));
        return new PageInfo<>(teacherList,navigatePage);
    }
}
