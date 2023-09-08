package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 知识点表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("knowledge_bullet")
public class KnowledgeBullet {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String knowledgePoint;

    private Integer subjectId;

    //代表这个属性不是数据库里的列
    @TableField(exist = false)
    private Subject subject;

    private Date updateTime;

    @TableLogic
    private Boolean enable;
}
