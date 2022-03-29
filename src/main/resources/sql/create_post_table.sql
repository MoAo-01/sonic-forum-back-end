CREATE TABLE post (
    pid INT AUTO_INCREMENT COMMENT '帖子id',
    username VARCHAR(20) NOT NULL COMMENT '用户名',
    post_name VARCHAR(128) NOT NULL COMMENT '帖子名称',
    text TEXT NOT NULL COMMENT '帖子内容',
    likes INT COMMENT '点赞',
    hates INT COMMENT '踩',
    access_permission VARCHAR(20) COMMENT '访问权限: only-me/public/private',
    access_times INTEGER COMMENT '访问次数',
    is_delete INT COMMENT '是否删除：0-未删除，1-已删除',
    is_select INT COMMENT '是否精选：0-未精选，1-精选',
    is_above INT COMMENT '是否精选：0-不置顶，1-置顶',
# 标签max account=8
    tag1 VARCHAR(20),
    tag2 VARCHAR(20),
    tag3 VARCHAR(20),
    tag4 VARCHAR(20),
    tag5 VARCHAR(20),
    tag6 VARCHAR(20),
    tag7 VARCHAR(20),
    tag8 VARCHAR(20),
# 备用字段
    feature1 VARCHAR(20),
    feature2 VARCHAR(20),
    feature3 VARCHAR(20),
    feature4 VARCHAR(20),
    feature5 VARCHAR(20),
    feature6 VARCHAR(20),
    feature7 VARCHAR(20),
    feature8 VARCHAR(20),
# 日志部分
    created_user VARCHAR(20) COMMENT '日志-创建人',
    created_time DATETIME COMMENT '日志-创建时间',
    modified_user VARCHAR(20) COMMENT '日志-最后修改执行人',
    modified_time DATETIME COMMENT '日志-最后修改时间',
    PRIMARY KEY (pid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;