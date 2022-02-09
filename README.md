# jsonNotes

## master分支

测试 mybatis-plus 使用 jsonNotes

```
|- sql
|   |- 【数据库 migration】
|- src
|   |- main
|   |   |- java
|   |   |   |- config 【mybatis plus配置】
|   |   |   |- entity 【数据库实体】
|   |   |   |- mapper 【mapper】
|   |   |- resource 【yaml配置】
|   |- test
|   |   |- java
|   |   |   |- test【测试类】
|   |   |   |   |- JsonNotesApplicationTests 【创建索引】
|   |   |   |   |- JsonNotesTest 【测试索引生效情况】
|- pom.xml
|- README.md
```

## shardingJdbc分支

测试 shardingJdbc + mybatis-plus 使用 jsonNotes

> 2022/2/8 ：
> 目前不支持，已提给 Apache ShardingSphere，反馈一周内会支持。一周后在测

> 2020/2/9：
> SphereEx开源牛逼，已适配sql语法，等merge后就能测了
> https://community.sphere-ex.com/t/topic/763/4
> 
- 改动点
    1. 新增依赖 pom.xml
    ```xml
            <!--druid依赖-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>1.2.8</version>
            </dependency>
    
            <!-- sharding-jdbc-->
            <dependency>
                <groupId>org.apache.shardingsphere</groupId>
                <artifactId>shardingsphere-jdbc-core-spring-boot-starter</artifactId>
                <version>5.0.0</version>
            </dependency>
    ```
    2. 修改 src/main/resources/application.yml
    3. 新增测试类 src/test/java/com/example/jsonnotes/ShardingJdbcTest.java