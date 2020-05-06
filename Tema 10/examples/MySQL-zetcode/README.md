# [MySQL Java tutorial (zetcode.com by Jan Bodnar)](http://zetcode.com/db/mysqljava/)

Java tutorial for the MySQL database. It covers the basics of MySQL programming in Java with JDBC.

We use the MySQL Connector/J driver. It is the official JDBC driver for MySQL. The examples were created and tested on Ubuntu Linux.

## JDBC

JDBC is an API for the Java programming language that defines how a client may access a database. It provides methods for querying and updating data in a database. JDBC is oriented towards relational databases. From a technical point of view, the API is as a set of classes in the java.sql package. To use JDBC with a particular database, we need a JDBC driver for that database.

JDBC is a cornerstone for database programming in Java. Today, it is considered to be very low-level and prone to errors. Solutions such as MyBatis or JdbcTemplate were created to ease the burden of JDBC programming. However, under the hood, these solutions still use JDBC. JDBC is part of the Java Standard Edition platform.

JDBC manages these three main programming activities:

- connecting to a database;
- sending queries and update statements to the database;
- retrieving and processing the results received from the database in answer to the query.

## Create a test user

We create a new **testdb** database. We will use this database throughout the tutorial. 

```
mysql> CREATE DATABASE testdb;
```

```
mysql> GRANT ALL ON testdb.* TO 'testuser'@'localhost';
```
## Java examples ordered as they appear in this tutorial

1. JdbcMySQLVersion.java
2. RunningSQLScript.java (not in the original tutorial)
3. JdbcPrepared.java
4. JdbcNotPreparedTesting.java
5. JdbcPreparedTesting.java
6. JdbcRetrieve.java
7. JdbcProperties.java (see resources/db.properties)
8. ComLineDSEx.java
9. JdbcMulStat.java
10. JdbcColumnHeaders.java
11. JdbcAutoGenKey.java
12. JdbcWriteImage.java
13. JdbcReadImage.java
14. JdbcTransaction.java
15. JdbcNoTransaction.java
16. JdbcBatchUpdate.java
17. ExportCSV.java

## java.util.logging references

- [Logger log() Method in Java with Examples (geeksforgeeks.org)](https://www.geeksforgeeks.org/logger-log-method-in-java-with-examples/)
- [java.util.logging Example (javacodegeeks.com)](https://examples.javacodegeeks.com/core-java/util/logging/java-util-logging-example/)
- [Java Logging API - Tutorial (Lars Vogel)](https://www.vogella.com/tutorials/Logging/article.html)

## Java MySQL version

We check the version of the MySQL server:

- JdbcMySQLVersion.java (e01)

References:
- [5.1.14 MySQL Server Time Zone Support (MySQL 8.0 Reference Manual)](https://dev.mysql.com/doc/refman/8.0/en/time-zone-support.html)
- [https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue](https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue)


## Creating and populating tables

- RunningSQLScript.java (e02)

Next we are going to create database tables and fill them with data. These tables will be used throughout this tutorial.

References: 
- [How to run .SQL script using JDBC?](https://www.tutorialspoint.com/how-to-run-sql-script-using-jdbc)
- [MyBatis SQL Mapper Framework for Java](https://github.com/mybatis/mybatis-3)

You can execute .sql script files in Java using the **runScript()** method of the **ScriptRunner** class of **Apache iBatis**.

## Java MySQL prepared statements

When we write prepared statements, we use placeholders instead of directly writing the values into the statements. Prepared statements increase security and performance.

In Java a PreparedStatement is an object which represents a precompiled SQL statement.

- JdbcPrepared.java (e03)

## Testing MySQL prepared and not prepared statements
 
Reference:
- [Java – Measure elapsed time (howtodoinjava.com)](https://howtodoinjava.com/java/date-time/execution-elapsed-time/)

For the following two examples, we will use the Testing table. We will execute a normal statement and a prepared statement 5000 times. We check if there is some difference in execution time. 

- JdbcNotPreparedTesting.java (e04)

- JdbcPreparedTesting.java (e05)

## Java MySQL retrieving data

Next we will show how to retrieve data from a database table. We get all data from the Authors table.

- JdbcRetrieve.java (e06)

## Properties

It is a common practice to put the configuration data outside the program in a separate file. This way the programmers are more flexible. We can change the user, a password or a connection url without needing to recompile the program. It is especially useful in a dynamic environment, where is a need for a lot of testing, debugging, securing data etc.

In Java, the Properties is a class used often for this. The class is used for easy reading and saving of key/value properties. 

We have a **db.properties** file in which we have three key/value pairs. These are dynamically loaded during the execution of the program. 

- JdbcProperties.java (e07 - see resources/db.properties)

## Java MySQL datasource

In this example, we connect to the database using a data source. The usage of a data source improves application's performance and scalability. Using a datasource has several advantages over the DriverManager: increased portability, connection pooling, and distributed transactions.

The MysqlDataSource is a class for creating datasources. 

- ComLineDSEx.java (e08 - see resources/mysql.properties)

## Java MySQL multiple statements

It is possible to execute multiple SQL statements in one query. The allowMultiQueries must be set to enable multiple statements in MySQL.
 
- JdbcMulStat.java (e09)

## Java MySQL column headers

The following example shows how to print column headers with the data from the database table. We refer to column names as MetaData. MetaData is data about the core data in the database.
 
- JdbcColumnHeaders.java (e10)

## MySQL Java auto-generated keys

MySQL's AUTO_INCREMENT attribute generates a unique ID for new rows. The following example shows how we can use JDBC to retrieve an auto-generated key value.

- JdbcAutoGenKey.java (e11)

## MySQL Java writing images

Some people prefer to put their images into the database, some prefer to keep them on the file system for their applications. Technical difficulties arise when we work with lots of images. Images are binary data. MySQL database has a special data type to store binary data called **BLOB (Binary Large Object)**.

- JdbcWriteImage.java (e12)

For this example, we use the Images table.

Image: tree.png
- Autor pictogramas: Sergio Palao Procedencia: ARASAAC (http://arasaac.org)
- Licencia: CC (BY-NC-SA) Propiedad: Gobierno de Aragón

## MySQL Java reading images

In the previous example, we have inserted an image into the database table. Now we are going to read the image back from the table.

- JdbcReadImage.java (e13)

## Transaction support

A *transaction* is an atomic unit of database operations against the data in one or more databases. The effects of all the SQL statements in a transaction can be either all committed to the database or all rolled back.
 
The MySQL database has different types of storage engines. The most common are the MyISAM and the InnoDB engines. There is a trade-off between data security and database speed. The MyISAM tables are faster to process and they do not support transactions. On the other hand, the InnoDB tables are more safe against the data loss. They support transactions and are slower to process.  

- JdbcTransaction.java (e14)
- JdbcNoTransaction.java (e15)

## Batch updates

When we need to update data with multiple statements, we can use batch updates. Batch updates are available for INSERT, UPDATE, DELETE, statements as well as for CREATE TABLE and DROP TABLE statements.

- JdbcBatchUpdate.java (e16)

## Exporting data to a CSV file
 
The next example exports data into a CSV file.
 
We need to have proper file permissions for our testuser; otherwise, we get access denied error message.

``` 
mysql> GRANT FILE ON *.* TO 'testuser'@'localhost';
```
 
We set the FILE permission.

``` 
 mysql> SHOW VARIABLES LIKE "secure_file_priv";
 +------------------+-----------------------+
 | Variable_name    | Value                 |
 +------------------+-----------------------+
 | secure_file_priv | /var/lib/mysql-files/ |
 +------------------+-----------------------+
```

- ExportCSV.java (e17)
