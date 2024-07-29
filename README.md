# Rest to Kotlin

Aplicação para aprofundar conceitos básicos e sintaxe de desenvolvimento de Kotlin.

## Projeto

O projeto consiste em uma aplicação REST com um simples CRUD de criação de fóruns alocados na memória. Nesta primeira versão, a aplicação será simples, mas evoluirá para uma versão mais avançada com conectividade a um banco de dados MongoDB.

## Estrutura de Pastas

```bash
rest-service
|__ src
    |__ main
        |__ kotlin
            |__ br.com.shark.rest_service
                |__ controllers
                |__ dto
                |__ models
                |__ service
        |__ RestServiceApplication.kt
```
## Dependências

Para este projeto, utilizaremos o JDK 17. Você pode fazer o download do JDK 17 no seguinte link:

- [JDK 17 Download](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)

### Configuração Maven

Adicione as seguintes dependências ao seu arquivo `pom.xml` para configurar o projeto Kotlin com Maven:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>br.com.shark</groupId>
    <artifactId>rest-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>rest-service</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>17</java.version>
        <kotlin.version>1.9.24</kotlin.version>
    </properties>
    <dependencies>
        <!-- Spring Boot Starter Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot Starter Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Jackson Kotlin Module -->
        <dependency>
            <groupId>com.fasterxml.jackson.module</groupId>
            <artifactId>jackson-module-kotlin</artifactId>
        </dependency>

        <!-- Kotlin Standard Library -->
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-stdlib</artifactId>
        </dependency>

        <!-- Kotlin Reflection -->
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-reflect</artifactId>
        </dependency>

        <!-- Spring Boot DevTools (runtime only) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <!-- Spring Boot Starter Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Kotlin Test JUnit5 -->
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-test-junit5</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
        <testSourceDirectory>${project.basedir}/src/test/kotlin</testSourceDirectory>
        <plugins>
            <!-- Spring Boot Maven Plugin -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <!-- Kotlin Maven Plugin -->
            <plugin>
                <groupId>org.jetbrains.kotlin</groupId>
                <artifactId>kotlin-maven-plugin</artifactId>
                <version>${kotlin.version}</version>
                <configuration>
                    <args>
                        <arg>-Xjsr305=strict</arg>
                    </args>
                    <compilerPlugins>
                        <plugin>spring</plugin>
                    </compilerPlugins>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.jetbrains.kotlin</groupId>
                        <artifactId>kotlin-maven-allopen</artifactId>
                        <version>${kotlin.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
</project>

```
Além disso, adicione o plugin do Kotlin e o plugin do Spring Boot ao seu arquivo pom.xml:

```xml
<build>
    <plugins>
        <!-- Plugin do Kotlin -->
        <plugin>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-plugin</artifactId>
            <version>1.9.0</version>
            <executions>
                <execution>
                    <goals>
                        <goal>compile</goal>
                        <goal>test-compile</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <jvmTarget>17</jvmTarget>
            </configuration>
        </plugin>

        <!-- Plugin do Spring Boot -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
Certifique-se de que o JDK 17 está configurado no seu Maven:

```xml
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
</properties>

```

## Docker

Para executar o Dockerfile, basta usar o seguinte comando:

```bash
docker build -t nome-da-sua-escolha/rest-service:tag .
```

Se desejar usar o Docker Compose para gerenciar o ambiente, você pode utilizar o comando abaixo. Este comando irá iniciar a aplicação com toda a configuração de memória e CPU provisionada:

```bash
docker-compose up -d
```

Note que o comando docker-compose up -d deve ser executado no diretório onde o arquivo docker-compose.yml está localizado.

