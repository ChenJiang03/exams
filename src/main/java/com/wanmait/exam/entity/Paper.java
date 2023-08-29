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
 * 试卷
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
public class Paper {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer totalScore;

    private Integer paperModelId;

    private Integer teacherId;

    private Date inputTime;

    @TableLogic
    private Boolean enable;
}
