# Non-Heritage Digital Preservation Platform

Welcome to the Non-Heritage Digital Preservation Platform project!

This platform is designed to digitally preserve and showcase intangible cultural heritage items, offering features such as project displays, inheritor profiles, and workshop reservations.

---

## 中文版

请查看中文版本：[README-CN.md](README-CN.md)



## English Version

You are reading the English version of this document.

---

## Deployment Guide

### Environment Requirements

- **JDK 21**  
  - Verify installation: `java -version`  
  - Set environment variable: ensure `JAVA_HOME` points to your JDK 21 installation path

- **Apache Maven 3.9+**  
  - Download: [Maven Official Site](https://maven.apache.org/)  
  - Configure: add `MAVEN_HOME` to environment variables, verify with `mvn -v`

- **Apache Tomcat 9**  
  - Download: [Tomcat Official Site](https://tomcat.apache.org/)  
  - Set `CATALINA_HOME` to your Tomcat installation directory

- **MySQL 8.0+**  
  - Download and install: [MySQL Official Site](https://www.mysql.com/)  
  - Remember your root password for future database setup

---

### Deployment Steps

#### 1. Clone the Repository

```bash
git clone https://github.com/ivy-blanche/non-heritage-platform.git
cd non-heritage-platform
````

#### 2. Configure the Database

Create the database:

```sql
CREATE DATABASE non_heritage CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Configure database connection in the project:

Edit `src/main/resources/application.properties`:

```properties
jdbc.url=jdbc:mysql://localhost:3306/db_heritage
jdbc.username=your username
jdbc.password=your password
```

#### 3. Build the Project

Use Maven to build a WAR package:

```bash
mvn clean package
```

After successful build, the `non-heritage-platform.war` file will be generated in the `target/` directory.

#### 4. Deploy to Tomcat

Stop the Tomcat service:

```bash
cd $CATALINA_HOME/bin
./shutdown.sh
```

Copy the WAR file to the Tomcat `webapps` directory:

```bash
cp target/non-heritage-platform.war $CATALINA_HOME/webapps/
```

Start Tomcat:

```bash
./startup.sh
```

Check Tomcat logs to confirm successful deployment:

```bash
tail -f $CATALINA_HOME/logs/catalina.out
```

#### 5. Access the Application

Open your browser and visit:

```
http://localhost:8080/non-heritage-platform/
```

---

## Troubleshooting

### 1. 404 Page Not Found After Deployment

* Check Tomcat logs to ensure the WAR file was unpacked correctly
* Visit [http://localhost:8080/manager/html](http://localhost:8080/manager/html) to see deployed applications
* Try manually deleting the `webapps/non-heritage-platform` directory and restarting Tomcat

### 2. Database Connection Issues

* Ensure the database settings in `db.properties` are correct
* Confirm that MySQL is running and the database name is correct
* Test database connection using MySQL CLI:

```bash
mysql -h localhost -u root -p non_heritage
```

### 3. Maven Build Failure

* Check your network connection to ensure Maven can download dependencies
* Clean Maven cache and rebuild:

```bash
mvn clean package -U
```

* Check for dependency conflicts in `pom.xml`

---

## Contact & Support

If you encounter any issues during deployment, feel free to contact us via:

* GitHub Issues: [https://github.com/ivy-blanche/non-heritage-platform/issues](https://github.com/ivy-blanche/non-heritage-platform/issues)
* Email: [xingzhiin2020s@gamil.com](mailto:xingzhiin2020s@gamil.com)

We will get back to you as soon as possible!

