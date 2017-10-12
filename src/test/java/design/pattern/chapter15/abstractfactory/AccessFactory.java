package design.pattern.chapter15.abstractfactory;

/**
 * Created by h on 2017/10/13.
 */
public class AccessFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new AccessUser();
    }
}
