package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
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
@Accessors(chain = true)
@TableName("knowledge_bullet")
public class KnowledgeBullet {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String knowledgePoint;

    private Integer subjectId;

    private Date updateTime;

    @TableLogic
    private Boolean enable;
}
