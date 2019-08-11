<h1>
    <center>ASSblog</center>
    <h3><center>一个简单的SpringBoot博客后端</center><h3>
</h1>

![GitHub](https://img.shields.io/github/license/chenmoand/ASSblog)  ![GitHub last commit (branch)](https://img.shields.io/github/last-commit/chenmoand/ASSblog/master)  ![GitHub stars](https://img.shields.io/github/stars/chenmoand/ASSblog)

>  序言: 这是我暑假学的, 可能有不明觉厉的代码别喷啊, 觉得有帮助有点个star呗!  **暂且未完成!**
>
>  前端地址: [ReactBlog](https://github.com/chenmoand/ReactBlog)

### 一, 如何使用

- git clone https://github.com/chenmoand/ASSblog.git 下载项目
- cd ASSblog 进入项目目录
- 将**sql/*.sql** 输入到你的数据库内, 名字类型可自行改动,不过需要修改*Mapper.xml文件
- 将**src/main/resources/application-test.yml**文件修改自己的数据,并将-test去掉
- 配置完成后就可以启动项目

### 二, 用到了什嘛

1. Mybatis-plus 数据库连接简化

2. druid 数据库连接池

3. Mysql 数据库

4. Security + JWT web请求检测

### 三, 项目结构 

```
|-- com
|   `-- brageast
|       `-- blog
|           |-- BlogApplication.java 启动入口
|           |-- config 配置文件
|           |   |-- DruidConfig.java
|           |   |-- MyBatisConfig.java
|           |   |-- SecurityConfig.java
|           |   `-- ServerConfig.java
|           |-- controller API地址
|           |   |-- AriticleController.java
|           |   |-- DruidController.java
|           |   `-- UserController.java
|           |-- entity 实体
|           |   |-- Article.java
|           |   |-- BaseArticle.java
|           |   |-- Group.java
|           |   |-- Permissions.java
|           |   |-- User.java
|           |   `-- jwt 
|           |       `-- JwtUser.java
|           |-- filter 检查器
|           |   |-- GustAccessDenyFilter.java 匿名用户检查
|           |   |-- JwtTokenFilter.java       Token检查
|           |   `-- UserAccessDenyFilter.java 无权限用户检查
|           |-- mapper 跟mybatis联动的地方
|           |   |-- ArticleMapper.java 文章获取
|           |   |-- GroupMapper.java
|           |   |-- PermissionsMapper.java
|           |   `-- UserMapper.java
|           |-- service 服务
|           |   |-- ArticleService.java
|           |   |-- GroupService.java
|           |   |-- PermissionService.java
|           |   |-- UserService.java
|           |   `-- impl 实现服务的地方
|           |       |-- ArticleServiceImpl.java
|           |       |-- PermissionServiceImpl.java
|           |       |-- UserDetailsServiceImpl.java
|           |       `-- UserServiceImpl.java
|           `-- util 工具
|               |-- EntityUtil.java 偷懒类的联动
|               |-- JwtUtil.java Token生成工具
|               |-- MyPasswordEncoder.java 密码校验工具
|               |-- PasswordTools.java 阿里爸爸的密码加密工具
|               `-- entity
|                   |-- Combination.java 偷懒类
|                   |-- ResultState.java 用于返会状态方便转JSON的类
|                   `-- State.java 一个enum状态类
```

~~tree指令生成~~ 2019.8.11 文件目录更新

### 四, 踩坑记录

我把他单独拿到了一个md文件 **[Chick Here](./踩坑.md)**

