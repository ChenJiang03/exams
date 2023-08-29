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
 * 教师表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
public class Teacher {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String idcard;

    private Boolean sex;

    private String pic;

    private Date inputTime;

    /**
     * 出题数量
     */
    private Integer questionCount;

    @TableLogic
    private Boolean enable;
}
