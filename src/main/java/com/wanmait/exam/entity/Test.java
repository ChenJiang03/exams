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
 * 考试表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
public class Test {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private Integer subjectId;

    private Integer paperId;

    private Integer classId;

    private Date startTime;

    private Date endTime;

    private Integer teacherId;

    private Date inputTime;

    @TableLogic
    private Boolean enable;
}
