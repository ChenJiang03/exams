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
 * 
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("question_analysis")
public class QuestionAnalysis {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer questionId;

    private String questionAnalysis;

    private Date inputTime;

    private Integer userId;

    @TableLogic
    private Boolean enable;
}
