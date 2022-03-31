# sonic-forum-back-end

## 配置文件：
- src\main\resources\application.properties
- 请修改为目标数据库，本地/远端
- 修改用户名/密码

## 需要配置环境：
1. mybatis-plus
2. lombok
3. SpringBoot

## 数据库管理工具：
- 建议使用：Navicat
- [激活指南](https://www.newadmin.cn/archives/1852)

## Sql文件路径：
- src\main\resources\sql

## Done:
1. User Table Created
2. Post Table Created
3. CURD JUnit Tests
4. User 服务层 (基本完成)

## To Do:
1. User Controller 层 (User Get接口完成)
2. Post 服务层
3. Post Controller 层
4. About 验证码 [参考资料](https://www.cnblogs.com/FlyHeLanMan/p/6293991.html)

## About Spring Security
1. 声明了Spring安全框架，每次访问web前先要做开发认证
2. 用户名: 默认为 user
3. 密码: 在 idea 的命令框内，每次由框架自动生成，打印
4. 登录后可以正常访问相关网址，做接口测试
5. ToDo 后期把认证关闭，增加拦截器

## API文档
了解接口文档的规范，接口分为四部分：请求方法、URL、请求参数、返回参数：

1. 常用请求方法，四类：GET、PUT、POST、DELETE
2. URL
3. 请求参数和返回参数：请求参数和返回参数都分为：字段、说明、类型、备注、是否必填这5列
4. JSON扩展工具: Json-handle (Chrome浏览器支持)
    安装方式：
    1. [网页下载](http://jsonhandle.sinaapp.com/)
    2. Chrome浏览器键入: `chrome://extensions/` 回车
    3. 推入下载的 `JSON-handle_0.6.1.crx` 安装包到网页，完成
    4. 效果展示：

![image](https://user-images.githubusercontent.com/83717535/160980775-3b6fbb43-dc1d-42b9-98d5-750c1e1f606a.png)
![image](https://user-images.githubusercontent.com/83717535/160981061-94cf3ff4-4146-4a0a-87e5-a96fef533e3a.png)



[API文档说明总结](https://blog.csdn.net/qq_34207366/article/details/84579475)

```javascript
{
    "state":200,
    "message":"success",
    "data":{
        "username":"Alice",
        ...
    }
}
```

```javascript
{
    "state":404,
    "message":"Not Found"
    "data":{}
}
```

## 接口维护/测试工具

- Postman
- [APIPost](https://console.apipost.cn/)

## UI design markdown editor (Not for back-end)

- [markdown editor](https://codingdict.com/os/software/51495)

