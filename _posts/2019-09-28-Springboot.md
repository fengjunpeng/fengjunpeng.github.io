---

---

#   Springboot

##  为什么要用Springboot

1、传统项目：整合 SSH 或者 SSM，考虑 __配置文件xml__ 、 __jar包冲突__ 、 整合框架繁琐，传统项目先读取 web.xml，读取配置，再启动 SpringMVC , 加载 Spring 框架。

2、打包方式：传统项目要打包成一个 war 包，放入 tomcat webapps 目录下进行项目执行。

##  SpringBoot是什么

Springboot 是一个快速开发框架，能帮助开发者快速整合第三方常用框架（底层采用 Maven 依赖关系实现 ## Maven 继承），完全采用注解化（简化 xml 配置），内置嵌入 Http 服务器（tomcat、jetty），默认嵌入 tomcat 服务器。最终以 __java 应用程序进行执行。__ 因为是内嵌入服务器方式，不需要外部运行项目。

springboot 项目没有 web.xml ，核心是第三方框架、完全采用注解化，Spring3.0后采用注解方式启动 SpringMVC ，内置嵌入 HTTP 服务器 java 创建 tomcat。

##  Springboot 与 SpringCloud 的关系

1、Springboot 是一个快速开发框架，能帮助开发者快速整合第三方常用框架，完全采用注解化，简化 xml 配置，内置嵌入 Http 服务器（tomcat、jetty），以 java 应用程序进行执行

2、SpringCloud 是一套微服务解决框架，功能强大。内置注册中心，客户端调用工具，服务治理（负载均衡、断路器、分布式配置中心、网关、服务链路、消息总线等）

3、dubbo 在 SpringCloud 出现之前很火，注册中心使用 zk ，有负载均衡。

springboot 不是微服务框架，springboot + springcloud 实现微服务开发

微服务通信技术 http + json 轻量级

springcloud 依赖 springboot 实现微服务

总结：springcloud 与 springboot 区别

（微服务开发------依赖 RPC 远程服务调用、服务治理）

核心区别：

springcloud 是一个微服务框架，涉及到 RPC 远程调用，单纯的只是基于 Springboot 实现快速开发。

##  Springboot 与 SpringMVC 关系

springboot web 组件默认集成 springmvc ，但是 SpringBoot 启动 SpringMVC 的时候没有配置传统的 xml 文件。 springmvc 3.0 后支持注解方式启动 SpringMVC （使用 java 代码启动 SpringMVC），简化 xml ，内置嵌入 HTTP 服务器（tomcat、jetty） 