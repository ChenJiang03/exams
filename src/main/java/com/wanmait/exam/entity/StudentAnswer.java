package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("student_answer")
public class StudentAnswer {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer testId;

    private Integer questionId;

    private Integer studentId;

    private String studentAnseer;

    private Integer studentScore;
}
