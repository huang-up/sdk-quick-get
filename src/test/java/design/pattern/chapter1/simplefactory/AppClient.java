package design.pattern.chapter1.simplefactory;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/9/21.
 */
public class AppClient {
    private static final Logger logger = Logger.getLogger(AppClient.class);
    public static void main(String[] args) {
        logger.info(getResult(1,2,"+"));
    }

    public static double getResult(double numA, double numB, String operate) {
        Operation operation = OperationFactory.createOperation(operate);
        operation.numA = numA;
        operation.numB = numB;
        return operation.getResult();
    }
}
