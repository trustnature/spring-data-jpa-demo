本项目用作 Spring-Data_-Jpa 研究使用。

=========master branch: Spring 框架对 JPA 的支持=========
-----------Spring JDBC Template 使用方式---------

Spring 框架对 JPA 提供的支持主要体现在如下几个方面：
首先，它使得 JPA 配置变得更加灵活。JPA 规范要求，配置文件必须命名为 persistence.xml，并存在于类路径下的 META-INF 目录中。
该文件通常包含了初始化 JPA 引擎所需的全部信息。Spring 提供的 LocalContainerEntityManagerFactoryBean 提供了非常灵活的配置，
persistence.xml 中的信息都可以在此以属性注入的方式提供。

其次，Spring 实现了部分在 EJB 容器环境下才具有的功能，比如对 @PersistenceContext、@PersistenceUnit 的容器注入支持。

第三，也是最具意义的，Spring 将 EntityManager 的创建与销毁、事务管理等代码抽取出来，并由其统一管理，开发者不需要关心这些，
如前面的代码所示，业务方法中只剩下操作领域对象的代码，事务管理和 EntityManager 创建、销毁的代码都不再需要开发者关心了。