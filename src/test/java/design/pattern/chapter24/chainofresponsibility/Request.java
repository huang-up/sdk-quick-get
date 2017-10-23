package design.pattern.chapter24.chainofresponsibility;

/**
 * Created by h on 2017/10/22.
 */
public class Request {
    private String name;
    private String type;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
