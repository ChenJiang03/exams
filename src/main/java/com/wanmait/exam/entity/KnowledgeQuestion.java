package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Data
@Accessors(chain = true)
@TableName("knowledge_question")
public class KnowledgeQuestion {

    private Integer questionId;

    private Integer knowledgeId;

    @TableField(exist = false)
    private Question question;

    @TableField(exist = false)
    private KnowledgeBullet knowledgeBullet;
}
