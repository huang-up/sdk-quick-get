package proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by h on 2018/3/4.
 */
@Slf4j
public class T {
    @Test
    public void t1() {
        SubjectProxy subjectProxy = new SubjectProxy();
        subjectProxy.doSomething();
    }

    @Test
    public void t2() {
        ProxyHandler proxyHandler = new ProxyHandler();
        ISubject subject = (ISubject) proxyHandler.bind(new Subject());
        subject.doSomething();
    }

    @Test
    public void t3() {

    }
}
