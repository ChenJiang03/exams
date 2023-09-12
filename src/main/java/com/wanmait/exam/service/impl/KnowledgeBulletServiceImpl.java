package com.wanmait.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanmait.exam.entity.KnowledgeBullet;
import com.wanmait.exam.entity.Question;
import com.wanmait.exam.entity.Subject;
import com.wanmait.exam.mapper.KnowledgeBulletMapper;
import com.wanmait.exam.service.KnowledgeBulletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 知识点表 服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
public class KnowledgeBulletServiceImpl extends ServiceImpl<KnowledgeBulletMapper, KnowledgeBullet> implements KnowledgeBulletService {

    @Resource
    private KnowledgeBulletMapper knowledgeBulletMapper;

    /*
        * @Author Chen Jiang
        * @Description
        *    分页查询所有知识点
        * @Date 2023/8/29 10:25
        * @Param [pageNum]
     */
    public PageInfo<KnowledgeBullet> findAll(Integer pageNum) {
        //TODO: 后期需要把这个地方修改成从数据库里拿配置
        int pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<KnowledgeBullet> knowledgeBullets = knowledgeBulletMapper.selectList();
        return new PageInfo<>(knowledgeBullets, pageNum);
    }

    /*
        * @Author Chen Jiang
        * @Description
        *    根据id删除知识点，这个方法为假删除
        * @Date 2023/8/29 10:25
        * @Param [id]
     */
    @Override
    public void deleteById(Integer id)
    {
        if (id == null)
        {
            return;
        }
        LambdaQueryWrapper<KnowledgeBullet> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(KnowledgeBullet::getId, id);
        knowledgeBulletMapper.delete(queryWrapper);
    }

    @Override
    public List<KnowledgeBullet> findAllById(Integer id) {
        return knowledgeBulletMapper.findAllById(id);
    }


}
