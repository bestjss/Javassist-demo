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