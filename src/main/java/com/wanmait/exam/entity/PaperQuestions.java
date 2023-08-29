package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 试卷题目表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("paper_questions")
public class PaperQuestions {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer questionId;

    private Integer paperId;

    private Integer score;

    private Integer sort;

    @TableLogic
    private Boolean enable;
}
