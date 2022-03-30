# sonic-forum-back-end

配置文件：
- src\main\resources\application.properties
- 请修改为目标数据库，本地/远端
- 修改用户名/密码

需要配置环境：
1. mybatis-plus
2. lombok
3. SpringBoot

数据库管理工具：
- 建议使用：Navicat
- [激活指南](https://www.newadmin.cn/archives/1852)

Sql文件路径：
- src\main\resources\sql

Done:
1. User Table Created
2. Post Table Created
3. CURD JUnit Tests
4. User 服务层 (基本完成)

To Do:
1. User Controller 层 (User Get接口完成)
2. Post 服务层
3. Post Controller 层

About Spring Security
1. 声明了Spring安全框架，每次访问web前先要做开发认真
2. 用户名: 默认为 user
3. 密码: 每次自动生成，在idea的命令框由框架自动打印
4. 登录后可以正常访问相关网址，做接口测试
5. ToDo 后期把认证关闭，增加拦截器
