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
 * 学生表
 * </p>
 *
 * @author wanmait
 * @since 2023-08-29
 */
@Getter
@Setter
@Accessors(chain = true)
public class Student {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String pic;

    private Boolean sex;

    private String idcard;

    private String degree;

    private Integer classId;

    private Date regTime;

    private Date lastLogin;

    private Boolean isGraduate;

    @TableLogic
    private Boolean enable;
}
