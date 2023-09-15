package com.wanmait.exam.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.Levels;
import com.wanmait.exam.entity.Subject;
import com.wanmait.exam.mapper.LevelsMapper;
import com.wanmait.exam.mapper.SubjectMapper;
import com.wanmait.exam.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 学科表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;


    @Override
    public PageInfo<Subject> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Subject> subjectList=subjectMapper.findAll();
        return new PageInfo<>(subjectList,5);
    }
}
