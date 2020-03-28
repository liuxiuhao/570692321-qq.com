## 简介
基于Spring-cloud-alibaba的分布式脚手架
## 版本说明
 * spring-boot 2.2.5.RELEASE
 * spring-cloud Hoxton.SR1
 * spring-cloud-alibaba 2.2.0.RELEASE
## 相关依赖
 * Nacos
 * Sentinel
 * lombok
## 目录结构
 ```
├─spring-cloud-alibaba-demo # 项目名
│  ├─consumer # 客户端应用模块 (根据实际情况自定义)
│  │  ├─src
│  │  │  ├─main
│  │  │  │  ├─java
│  │  │  │  │  └─com
│  │  │  │  │      └─liuxh
│  │  │  │  │          └─consumer
│  │  │  │  │              ├─controller #controller 存放目录
│  │  │  │  │              ├─service    #业务服务层
│  │  │  │  │              └─model      #model层
│  │  │  │  └─resources #资源目录
│  │  │  └─test
│  ├─consumer-facade #客户端应用接入的外部接口统一模块
│  │  ├─src
│  │  │  ├─main
│  │  │  │  ├─java
│  │  │  │  │  └─com
│  │  │  │  │      └─liuxh
│  │  │  │  │          └─consumer
│  │  │  │  │              └─facade
│  │  │  │  │                  ├─configuration # 配置类存放目录
│  │  │  │  │                  └─***Facade.java 每个接口对应的接入实现包括熔断Fallback实现等
│  │  │  └─test #测试类存放目录
│  ├─provider #服务端模块(根据实际情况自定义)
│  │  ├─src
│  │  │  ├─main
│  │  │  │  ├─java
│  │  │  │  │  └─com
│  │  │  │  │      └─liuxh
│  │  │  │  │          └─provider
│  │  │  │  │              ├─common       #公共类存放目录
│  │  │  │  │              ├─service      #业务服务类
│  │  │  │  │              ├─mapper       # dao层
│  │  │  │  │              └─controller   #controller层
│  │  │  │  └─resources #资源路径
│  │  │  └─test #测试路径
│  └─provider-api #服务端对外接口模块
│      ├─src
│      │  ├─main
│      │  │  └─java
│      │  │      └─com
│      │  │          └─liuxh
│      │  │              └─provider
│      │  │                  └─api
│      │  │                      ├─model   #model层
│      │  │                      └─service #服务接口层
│      │  └─test #测试类
```
**说明**
  1. provider-api 存放服务端对外提供的开放接口,包括接口中用到的请求和响应实体,这样方便对外接口统一管理
  2. provider的controller/openapi包下存放 provider-api中的接口实现
  3. consumer-facade存放的是引用的外部接口及其容错实现，方便对外部接口统一管理
  
 总体依赖关系为 provider-->provider-api<--consumer-facade<--consumer
 注: provider和consumer角色可能同时存在,互相增加 XXX-api或 XXX-facade就可以了
## 配置说明
   注:启动项目前需要启动Nacos服务, 根据需要启动Sentinal控制台
```
   #配置Nacos服务地址 其他参考 nacos官网
   spring.cloud.nacos.server-addr=127.0.0.1:8848
   #启用Sentinel作为熔断降级组件,如果需要
   feign.sentinel.enabled=true
   #配置Sentinel控制台地址,如果需要
   spring.cloud.sentinel.transport.dashboard=127.0.0.1:8080
```


  
