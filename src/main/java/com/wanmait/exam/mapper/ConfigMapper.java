package com.wanmait.exam.mapper;

import com.wanmait.exam.entity.Config;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
public interface ConfigMapper extends BaseMapper<Config> {
    String getConfigValueByConfigKey(String configKey);
}
