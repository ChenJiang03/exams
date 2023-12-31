package com.wanmait.exam.service.impl;

import com.wanmait.exam.entity.Config;
import com.wanmait.exam.mapper.ConfigMapper;
import com.wanmait.exam.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    @Resource
    private ConfigMapper configMapper;
    @Override
    public String selectConfigValueByConfigKey(String configKey) {
        return configMapper.getConfigValueByConfigKey(configKey);
    }
}
