# Record Domain Change history using hybrid of JPA and MyBatis 

## Problem
In some user cases, e.g. for audit purposes, the change history of domain objects should be persisted intentionally.

## Analysis
Obviously, customized coding should implement the solution. However, there is a spring project called `spring-data-envers` 
can also implement it out-of-the-box.

As the document said, `spring-data-envers` is based on `JPA` or `Hibernate` more detail. 
There are still a lot of requirements seeking the opportunities to operate the SQL directly, 
where `MyBatis` is mostly used.

Therefore, the solution should support both `JPA` and `MyBatis` at the same time.

## Solution
`Envers` can be enabled using `@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)`.
For others, there are no differences from normal `JPA` and `MyBatis` projects, except the two `Repository` beans should be seperated.

## Usage
All changes of the domain object, e.g. `create`, `modify`, `delete`, should use `JPA` repository beans in order the envers could record the log.
For query, both `JPA` and `MyBatis` can be used.

## Reference

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#howto.data-initialization.migration-tool.liquibase)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.jpa-and-spring-data)
* [Spring Data Envers](https://docs.spring.io/spring-data/envers/docs/current/reference/html/)

### Guides

The following guides illustrate how to use some features concretely:

* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

