package com.sonichollow.forum.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String createdUser;     //'日志-创建人'
    private Date createdTime;       //'日志-创建时间'
    private String modifiedUser;    //'日志-最后修改执行人'
    private Date modifiedTime;      //'日志-最后修改时间'
}



