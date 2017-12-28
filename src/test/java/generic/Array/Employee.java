package generic.array;

/**
 * Created by h on 2017/11/2.
 */
public class Employee extends Person {
    @Override
    public void run() {
        super.logger.info("Employee run");
    }
}
