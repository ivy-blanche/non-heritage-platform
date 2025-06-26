# 非遗数字化保护平台

欢迎使用非遗数字化保护平台项目！

该平台旨在通过数字化手段保存和展示非物质文化遗产，提供项目展示、传承人档案管理及工坊预约等功能。

---

## English Version

Please refer to the English version: [README-EN.md](README-EN.md)

---

## 非物质文化遗产平台部署指南

### 环境准备

- **JDK 21**  
  - 检查安装：`java -version`  
  - 环境变量：确保 `JAVA_HOME` 指向 JDK 21 安装目录

- **Apache Maven 3.9+**  
  - 下载：[Maven 官网](https://maven.apache.org/)  
  - 配置：添加 `MAVEN_HOME` 到环境变量，使用 `mvn -v` 验证安装

- **Apache Tomcat 9**  
  - 下载：[Tomcat 官网](https://tomcat.apache.org/)  
  - 配置：确保 `CATALINA_HOME` 指向 Tomcat 安装目录

- **MySQL 8.0+**  
  - 下载安装：[MySQL 官网](https://www.mysql.com/)  
  - 记住 root 密码，后续创建数据库使用

---

### 项目部署步骤

#### 1. 克隆项目

```bash
git clone https://github.com/ivy-blanche/non-heritage-platform.git
cd non-heritage-platform
````

#### 2. 数据库配置

创建数据库：

```sql
CREATE DATABASE non_heritage CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

在项目中配置数据库连接：

编辑 `src/main/resources/db.properties` 文件，修改如下：

```properties
jdbc.url=jdbc:mysql://localhost:3306/db_heritage
jdbc.username=你的账户名
jdbc.password=你的密码
```

#### 3. 构建项目

使用 Maven 构建 WAR 包：

```bash
mvn clean package
```

构建成功后，在 `target/` 目录下会生成 `non-heritage-platform.war` 文件。

#### 4. 部署到 Tomcat

停止 Tomcat 服务：

```bash
cd $CATALINA_HOME/bin
./shutdown.sh
```

复制 WAR 包到 Tomcat 的 `webapps` 目录：

```bash
cp target/non-heritage-platform.war $CATALINA_HOME/webapps/
```

启动 Tomcat 服务：

```bash
./startup.sh
```

查看 Tomcat 日志确认部署成功：

```bash
tail -f $CATALINA_HOME/logs/catalina.out
```

#### 5. 访问应用

打开浏览器访问：

```
http://localhost:8080/non-heritage-platform/
```

---

## 常见问题解决

### 1. 部署后页面显示 404

* 检查 Tomcat 日志，确认 WAR 包是否正确解压
* 访问 [http://localhost:8080/manager/html](http://localhost:8080/manager/html) 查看已部署应用
* 尝试手动删除 `webapps/non-heritage-platform` 目录，重启 Tomcat 让其重新解压

### 2. 数据库连接失败

* 检查 `db.properties` 中的数据库配置是否正确
* 确认 MySQL 服务已启动，且数据库名正确
* 尝试使用 MySQL 客户端测试连接：

```bash
mysql -h localhost -u root -p non_heritage
```

### 3. Maven 构建失败

* 检查网络连接，确保 Maven 可以下载依赖
* 清理本地 Maven 仓库缓存：

```bash
mvn clean package -U
```

* 检查 `pom.xml` 中是否有依赖冲突

---

## 联系支持

如在部署过程中遇到问题，请通过以下方式联系：

* 提交 GitHub Issue：[https://github.com/ivy-blanche/non-heritage-platform/issues](https://github.com/ivy-blanche/non-heritage-platform/issues)
* 邮件：[xingzhiin2020s@gamil.com](mailto:xingzhiin2020s@gamil.com)

我们会尽快回复并提供帮助！


