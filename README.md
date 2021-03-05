# Javassist-demo
- 比较好的Javassist中文说明资料
    - [JavaSSIST-1](https://www.jianshu.com/p/43424242846b)
    - [JavaSSIST-2](https://www.jianshu.com/p/b9b3ff0e1bf8)
    - [JavaSSIST-3](https://www.jianshu.com/p/7803ffcc81c8)

- Javassist Demo
    - agent：源码级别动态修改Demo
    - demo：测试用例

```shell script
# 执行命令
$ cd Javassist 
$ mvn clean package
$ cd D:\github\Javassist-demo\demo\target
# -javaagent: 代理jar的路径
# -Xbootclasspath/a： javassist-3.24.0-GA.jar 路径
# 说明： javassist 需要Xbootclasspath指定，可以配置在Maven maven-jar-plugin 中
# <Boot-Class-Path>D:\MavenRepository\org\javassist\javassist\3.24.0-GA\javassist-3.24.0-GA.jar</Boot-Class-Path>
# https://stackoverflow.com/questions/7685022/classpool-getdefault-does-nothing-in-javassist
$ java -javaagent:D:\github\Javassist-demo\agent\target\agent-1.0-SNAPSHOT.jar -Xbootclasspath/a:D:\MavenRepository\org\javassist\javassist\3.24.0-GA\javassist-3.24.0-GA.jar  -jar demo-1.0-SNAPSHOT.jar 
```

```shell script
# 结果
Run Proxy Agent
Demo Say ： 'Hello world'
耗时:
317
```

- 远程调试模式

启动命令加上-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n
    
- -XDebug:启动调试
- -Xrunjdwp: 加载JDWP的JPDA参考执行实例
- transport：用于在调试程序和远程应用服务使用的进程通信
- dt_socket: 套接字传输
- address=8000 :远程调试服务监听的端口号
- suspend=y/n : 在调试客户端建立连接之后挂起或启动应用服务

```shell script
# 例子 Springboot 服务
java -jar project.jar Java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n
```
