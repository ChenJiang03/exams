package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 选型表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Data
@Accessors(chain = true)
public class Choices {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private Boolean isCorrect;

    private Integer questionId;

    @TableLogic
    private Boolean enable;
}
