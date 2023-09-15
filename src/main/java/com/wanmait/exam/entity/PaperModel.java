package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("paper_model")
public class PaperModel {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer questionTypeId;

    private Integer questionCount;

    private Integer modelId;

    @TableField(exist = false)
    private Model model;

    @TableField(exist = false)
    private QuestionType questionType;
}
