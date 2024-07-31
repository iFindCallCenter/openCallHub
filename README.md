# openCallHub
OpenCallHub 是一个强大且灵活的开源呼叫中心解决方案，旨在提供全面的客户服务和支持功能

#### 项目地址 [GitHub](https://github.com/iFindCallCenter/openCallHub)

## 1、项目结构

    |--- och-api      接口服务
    |--- och-common   基础功能模块
    |--- och-esl      ESL客户端模块
    |--- och-file     文件模块
    |--- och-security 安全模块
    |--- och-system   系统模块

## 2、快速开始
1. 克隆项目到本地
```bash
git clone https://github.com/iFindCallCenter/openCallHub.git
cd openCallHub
```
2. 数据表创建
```bash
openCallHub/doc/system.sql 创建数据库表
```
3. 配置
``application.yml文件 数据库配置 redis配置``
4. 编译项目
```bash
mvn clean install
java -jar och-api.0.0.1.jar
```
5. 访问地址 http://localhost:8080/swagger-ui.html

6. 登录账号 admin/123456