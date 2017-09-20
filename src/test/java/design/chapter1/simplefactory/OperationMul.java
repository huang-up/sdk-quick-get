package design.chapter1.simplefactory;

/**
 * Created by admin on 2017/9/19.
 */
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        double result = 0;
        result = numA * numB;
        return result;
    }
}
