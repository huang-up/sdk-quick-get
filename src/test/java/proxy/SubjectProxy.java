package proxy;

/**
 * Created by h on 2018/3/4.
 */
public class SubjectProxy implements ISubject {
    Subject subject = new Subject();
    @Override
    public void doSomething() {
        subject.doSomething();
    }
}
