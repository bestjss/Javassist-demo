package org.litchi.assist.agent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @Auther Litchi_duan
 * @Date 2021/3/5
 * @Description
 */
public class AgentTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        // 全部Class内容，可根据情况自己过滤
        // System.out.println("transforming   "+className);

        // 我们只测试拦截Demo Start类
        if(!"org/litchi/assist/demo/Start".equals(className)){
            return null;
        }
        // 获取Javassist Class池
        ClassPool cp = ClassPool.getDefault();

        try{
            // 获取Class池中的CtClass对象
            CtClass ctClass = cp.getCtClass(className.replace("/","."));
            // 找到Main方法
            CtMethod method = ctClass.getDeclaredMethod("main");
            // 增加本地变量 - long 类型的 beginTime
            method.addLocalVariable("beginTime",CtClass.longType);
            // 在Main方法之前打印出耗时
            method.insertBefore("long beginTime = System.currentTimeMillis();");
            // 在Main 方法之后打印出耗时长短
            method.insertAfter("System.out.println(\"耗时:\");");
            method.insertAfter("System.out.println(System.currentTimeMillis() - beginTime);");
            // 返回修改后的字节码
            return ctClass.toBytecode();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}