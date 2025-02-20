# 毕设管理系统

## Introduce
毕设管理系统
前后端分离项目
- 基础功能
  所有用户登录操作。
  用户默认账号密码均为学号/工号。
  为保证安全，登录时检测到账号密码为默认值会要求修改密码，可忽略。
  登录后基于角色展示不同功能组件。

- 过程
  毕设由若干过程组成(开题答辩/期中检查/毕业答辩/毕设演示)，每过程包含不同评分占比，以及针对不同学生(导师指导学生/组内学生)。 不同专业/届可能有不同数据，因此由专业动态录入。
  每过程应包括

- 过程子项。过程由若干子项组成，子项包含占比。例如，开题答辩由选题依据50%+设计方案25%+答辩25%组成。
  学生附属项。过程允许包含若干学生附属项。例如，需要开题/毕业答辩需要学生上传ppt以及文档。
  其他隐形属性。
  过程不支持评分，过程应至少包含一个过程子项。

- 角色功能
  超级管理员
  独立角色，无导师操作权限。
  创建专业，导入包含指导数量/工号等信息的专业教师表格。

- 导师
  不包含秘书/主任等角色，所有导师教师具有相同操作权限。
  针对不同过程/过程子项，对学生评分。包括例如中期的指导学生及组内学生。

- 基本功能

创建过程，过程子项等
导入学生表格
按数量等自动分配导师
将学生随机分组/答辩顺序。分组原则，学生与指导教师不在同组，各组学生数尽量平均。
导入覆盖毕设题目/分组/顺序/导师等信息
重置指定账号密码
更新用户信息。支持修改导师/分组等。
导出详细评分表格
展示组内过程学生文件
学生
按学生附属项要求，上传文档。


- 初始化项目：
    - 创建空项目
    - 重构项目结构
    - 项目说明，readme
- 创建项目版本控制：
    - 创建Git忽略文件
    - 启动版本控制，创建项目初始化版本节点
- 实现项目：
    - Maven配置，Java版本，依赖等
    - 基础配置，logging，数据源等
    - 编程
    - 测试
    - 节点版本记录
      <br/>
      [**技术笔记**](tech.md)

## Contact

- **Email**: 1787802370@qq.com

- **Phone**: 19839704896

# Tools
- [接口文档]()
- IntelliJ IDEA 2024.1.4
- mysql
- jdk21

# Resource
```xml
spring:
  datasource:
    url: 'jdbc:mysql://120.46.159.231:3306/**********?createDatabaseIfNotExist=true'
    username: **********
    password: **********
    hikari:
      maximum-pool-size: 1
  sql:
    init:
      mode: always
#      自动生成数据表
logging:
  level:
    sql: debug
    org:
      example: debug
    root: warn
  pattern:
    console: '%-5level %C.%M[%line] - %msg%n'



#自定义密钥
my:
  secretkey: OIioun9
```
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.8</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>

```
```
mvn test
mvn jacoco:report
```
## Installation

## Updates
- 2025-02-20
  - 搭建websocket
- 2025-02-19
  - 修改service层 改用调用接口的方式调用函数
  - 每个类只关心自己的功能 不许关心具体实现 有新需求只要定义新的类 实现该接口新的函数即可 不用去修改内部代码
- 2025-02-17
    - 异步非阻塞重构代码
- 2025-01-21
    - [新版雪花算法](https://gitee.com/zerohek/idgenerator) 解决时钟回拨问题 （传统的雪花算法及其依赖系统时钟 当时钟回拨发生 有可能导致生成的id相同 从而出现严重崩溃）
    - 为什么不使用UUID
- 2024-12-17
    - 教师学生接口
- 2024-12-13
    - 异步非阻塞
- 2024-11-16
    - 添加测试覆盖率查询插件 jacoco 报告路径：build/reports/jacoco/test/html/index.html。
    - 测试覆盖率必须达到80%

- 2024-11-15
    - 管理员服务逻辑
- 2024-11-13
    - 读取文件分析出学生名单应该在前端完成 直接将数据通过持久层到数据库就行了
    - 添加拦截器 并注册拦截器
- 2024-10-10
    - 洗牌算法实现分派学生给教师
- 2024-10-01

    - 建立数据库 将数据表映射到java的do类
    - 不能吧repository的类声明为静态的
        - 原因在于：静态方法不支持依赖注入 Spring的事务管理依赖于实例方法 静态方法无法参与事务管理 静态方法可能引起并发问题 二实例方法在多线程场景之下更安全

## Usage guide