package org.litchi.assist.agent;

import java.lang.instrument.Instrumentation;

/**
 * @Auther Litchi_duan
 * @Date 2021/3/5
 * @Description 代理执行类
 */
public class ProxyAgent {

    /**
     * Java Agent 的入口
     * @param args
     * @param instrumentation
     */
    public static void premain(String args, Instrumentation instrumentation){
        System.out.println("Run Proxy Agent");
        instrumentation.addTransformer(new AgentTransformer());
    }
}