package proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by h on 2018/3/4.
 */
@Slf4j
public class Subject implements ISubject {
    @Override
    public void doSomething() {
        log.info("call doSomething");
    }
}
