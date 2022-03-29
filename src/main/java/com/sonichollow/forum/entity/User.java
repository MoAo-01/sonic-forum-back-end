package com.sonichollow.forum.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    //@TableId(type= IdType.AUTO)
    private Integer uid;            //'主键uid'
    private String username;        //'用户id'
    private String password;        //'密码'
    private String salt;            //'盐值'
    private String phone;           //'电话号码'
    private String email;           //'电子邮箱'
    private Integer gender;         //'性别:0-女，1-男'
    private String avatar;          //'头像'
    private Integer isDelete;       //'是否删除：0-未删除，1-已删除'
    private String createdUser;     //'日志-创建人'
    private Date createdTime;       //'日志-创建时间'
    private String modifiedUser;    //'日志-最后修改执行人'
    private Date modifiedTime;      //'日志-最后修改时间'
}