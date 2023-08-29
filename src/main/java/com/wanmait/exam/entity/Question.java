package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;
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
@Getter
@Setter
@Accessors(chain = true)
public class Question {

    private Integer id;

    private String title;

    private Integer levelId;

    private Integer subjectId;

    private Integer questionTypeId;

    private Integer knowledgeBulletId;

    private Date inputTime;

    private Integer teacherId;

    private Integer useCount;

    private Date updateTime;

    @TableLogic
    private Boolean enable;
}
