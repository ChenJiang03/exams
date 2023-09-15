package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 题目表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Data
@Accessors(chain = true)
public class Question {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private Integer levelId;

    private Integer subjectId;

    private Integer questionTypeId;

    private Date inputTime;

    private Integer teacherId;

    private Integer useCount;

    private Date updateTime;

    @TableLogic
    private Boolean enable;

    @TableField(exist = false)
    private QuestionType questionType;

    @TableField(exist = false)
    private Subject subject;

    @TableField(exist = false)
    private Levels levels;

    @TableField(exist = false)
    private Teacher teacher;
}
