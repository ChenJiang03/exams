package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class Grades {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer paperId;

    private Integer studentId;

    private Integer totalScore;

    @TableLogic
    private Boolean enable;
}
