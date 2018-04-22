package proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * Created by h on 2018/3/4.
 */
@Slf4j
public class ProxyHandler implements InvocationHandler {
    private Object tar;
    // 绑定委托对象，并返回代理类
    public Object bind(Object tar) {
        this.tar = tar;
        //
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        log.info("invoke before");
        result = method.invoke(tar, args);
        //在调用具体函数方法后，执行功能处理
        log.info("invoke after");
        return result;
    }
}