package com.wanmait.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 关联学生班级表
 * </p>
 *
 * @author wanmait
 * @since 2023-09-08
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("student_class")
public class StudentClass {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer classId;

    private Integer studentId;
}
