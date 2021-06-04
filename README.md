# mybatis-generator-support
some extensions for mybatis generator.

## Quick start

### 1. Add maven dependency for your mybatis-generator-plugin
```xml
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.2</version>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.25</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.3.5</version>
        </dependency>
        <dependency>
            <groupId>io.github.medusar</groupId>
            <artifactId>mybatis-generator-support</artifactId>
            <version>0.0.1</version>
        </dependency>
    </dependencies>
    <configuration>
        <configurationFile>src/main/resources/mybatis-generator-config.xml</configurationFile>
        <verbose>true</verbose>
        <overwrite>true</overwrite>
    </configuration>
</plugin>
```

### 2. Config Mybatis Generator
```
<commentGenerator type="io.github.medusar.mybatis.generator.support.SimpleCommentGenerator"/>
```

### 3. Run mybatis generator

## Supported versions
Because `mybatis-generator-support` depends on `mybatis-generator-core`, 
so you should make sure the versions match. 
| mybatis-generator-core | mybatis-generator-support |
| -- | -- |
| <= 1.3.5 | 0.0.1 | 