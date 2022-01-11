# myblog
个人博客springboot + Mybatis

### 一、技术栈

- 核心框架：SpringBoot 
- 项目构建：jdk1.8、Maven
- 持久层框架：Mybatis
- 模板框架：Thymeleaf
- 分页插件：PageHelper
- 加密：MD5加密

- MySQL 5.7

### 二、功能需求

用户权限管理只是简单区分一下管理员和普通用户

#### 1.普通用户

- 查看文章信息：文章列表、推荐文章、文章标题、文章内容、发布时间、访问量以及评论等信息
- 查看分类文章：分类列表、分类文章信息
- 查看时间轴：按照文章时间发布顺序查看文章
- 搜索文章：导航栏右边搜索框根据关键字搜索
- 听音乐：上一曲、下一曲、音量控制、播放顺序控制、查看歌词等
- 留言：留言并回复
- 查看友链：查看并访问博主在友链页面添加的友链连接
- 查看相册信息：相册列表、照片名称、照片拍摄地点、时间、照片描述

#### 2.管理员

- 拥有普通用户所有功能权限
- 登录：在主页路径下加“/admin”，可进入登录页面，根据数据库的用户名和密码进行登录
- 文章管理：查询文章列表、新增文章、编辑文章、删除文章、搜索文章
- 分类管理：查询分类列表、新增分类、编辑分类、删除分类
- 友链管理：查询友链列表、新增友链、编辑友链、删除友链
- 相册管理：查询相册列表、新增照片、编辑照片、删除照片
- 消息管理：登录后回复评论留言会显示博主的头像信息，并能显示删除消息按键，可以对消息进行删除

### 三、项目目录

![目录.PNG](src/main/resources/static/images/Show/目录.PNG)

增加功能：设置拦截器，防止恶意刷评论，刷留言功能

![限制评论.PNG](src/main/resources/static/images/Show/限制评论.PNG)

### 四、数据库设计

#### 1.数据表

- 博客数据表：t_blog
- 分类数据表：t_type
- 用户数据表：t_user
- 评论数据表：t_comment
- 留言数据表：t_message
- 友链数据表：t_friend
- 相册数据表：t_picture

#### 2.实体关系

- 博客和分类是多对一的关系：一个博客对应一个分类，一个分类可以对应多个博客
- 博客和用户是多对一的关系：一个博客对应一个用户，一个用户可以对应多个博客
- 博客和评论是一对多的关系：一个博客可以对应多个评论，一个评论对应一个博客
- 评论/留言和回复是一对多的关系：一个评论/留言可以对应多个回复，一个回复对应一个评论/留言
- 相册、友联和其他表没有关联

#### 3.实体属性

博客属性：

![blog.jpg](src/main/resources/static/images/Show/blog.jpg)

分类属性：

![type.jpg](src/main/resources/static/images/Show/type.jpg)

用户属性：

![user.jpg](src/main/resources/static/images/Show/user.jpg)

评论属性：

![comment.jpg](src/main/resources/static/images/Show/comment.jpg)

留言属性：

![message.jpg](src/main/resources/static/images/Show/message.jpg)

相册属性：

![picture.jpg](src/main/resources/static/images/Show/picture.jpg)

友链属性：

![friend.jpg](src/main/resources/static/images/Show/friend.jpg)





- 博客属性：标题、内容、首图、标记、浏览次数、赞赏开启、版权开启、评论开启、是否发布、创建时间、更新时间、描述
- 分类属性：分类名称
- 用户属性：昵称、用户名、密码、邮箱、类型、头像、创建时间、更新时间
- 评论属性：昵称、邮箱、头像、评论内容、创建时间、博客id、父评论id、管理员id
- 留言属性：昵称、邮箱、头像、留言内容、创建时间、父留言id、管理员id
- 友链属性：网址、名称、创建时间、图片地址
- 相册属性：图片地址、图片描述、图片名称、拍摄时间地点

#### 4.表结构

博客表

![t_blog.PNG](src/main/resources/static/images/Show/t_blog.PNG)

评论表

![t_comment.PNG](src/main/resources/static/images/Show/t_comment.PNG)

友链表

![t_friend.PNG](src/main/resources/static/images/Show/t_friend.PNG)

留言表

![t_message.PNG](src/main/resources/static/images/Show/t_message.PNG)

相册表

![t_picture.PNG](src/main/resources/static/images/Show/t_picture.PNG)

分类表

![t_type.PNG](src/main/resources/static/images/Show/t_type.PNG)

用户表

![t_user.PNG](src/main/resources/static/images/Show/t_user.PNG)

#### 5.页面展示
[展示](src/main/resources/static/images/Show/show.md)
