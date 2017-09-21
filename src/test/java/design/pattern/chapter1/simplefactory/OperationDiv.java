package design.pattern.chapter1.simplefactory;

/**
 * Created by admin on 2017/9/19.
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        double result = 0;
        if (numB == 0) {
            throw new RuntimeException("除数不能为0。");
        }
        result = numA / numB;
        return result;
    }
}
