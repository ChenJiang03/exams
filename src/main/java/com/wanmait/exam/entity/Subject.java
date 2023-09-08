package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学科表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Subject {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private Integer sort;

    private Date startTime;

    private Date endTime;

    private Boolean isCompleted;

    @TableLogic
    private Boolean enable;
}
