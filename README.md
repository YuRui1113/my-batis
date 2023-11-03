# Spring Boot中集成MyBatis和使用PostgreSQL数据库

### 1、关于MyBatis

> MyBatis是一流的持久性框架，支持自定义 SQL、存储过程和高级映射。 MyBatis消除了几乎所有的 JDBC 代码以及手动设置参数和检索结果。 MyBatis可以使用简单的 XML或注解进行配置，并将基本类型、接口和 Java POJO（普通旧 Java 对象）映射到数据库记录。
简单地说，它是 JDBC 和 Hibernate 的替代品。

### 2、开发环境

当前项目使用以下开发环境：
- 操作系统：Windows 11
- JDK 17
- 数据库：PostgreSQL 15.2
- IDE：VS Code（版本1.83.1），并安装以下插件：
  1. Extension Pack for Java
  1. Spring Boot Extension Pack

### 3、创建测试数据库

- 创建数据库

> 请在运行代码之前安装PostgreSQL数据库，并创建名为test的数据库。
可在命令行使用下面命令创建数据库：    

  `psql -h localhost -U postgres`

> 输入postgres用户密码后登录成功，再使用下面命令创建数据库test。

  `CREATE DATABASE test;`

- 创建Student表

  `CREATE TABLE students (
	  id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    sex BOOLEAN NOT NULL,
    age INTEGER NOT NULL,
    score INTEGER NULL,
    description VARCHAR
);`

- 添加测试数据

  `INSERT INTO public.students ("name", sex, age, description) VALUES('Taylor', false, 44, 'I am Taylor');  
  INSERT INTO public.students ("name", sex, age, description) VALUES('Tommy', false, 45, 'I am Tommy');
  INSERT INTO public.students ("name", sex, age, description) VALUES('Marisa', true, 40, 'I am Marisa');
  INSERT INTO public.students ("name", sex, age, description) VALUES('Jerry', false, 47, 'I am Jerry');
  INSERT INTO public.students ("name", sex, age, description) VALUES('Henry', false, 46, 'I am Henry');`