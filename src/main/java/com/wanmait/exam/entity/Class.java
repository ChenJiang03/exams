package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
public class Class {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 当前授课的学科id
     */
    private Integer subjectId;

    /**
     * 班级号
     */
    private Integer classNumber;

    /**
     * 班主任
     */
    private Integer headerTeacherId;

    /**
     * 当前任课教师id
     */
    private Integer teacherId;

    private Date startTime;

    private Date endTime;

    private Boolean isEnd;

    private Integer studentCount;

    private Date updateTime;

    @TableLogic
    private Boolean enable;
}
