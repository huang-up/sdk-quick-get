package design.chapter1.simplefactorymixstrategy;

/**
 * Created by admin on 2017/9/19.
 */
public abstract class Operation {
    protected double numA;
    protected double numB;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    abstract double getResult();
}
