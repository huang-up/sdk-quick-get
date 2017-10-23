package design.pattern.chapter24.chainofresponsibility.example;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/23.
 */
public abstract class Manager {
    protected static final Logger logger = Logger.getLogger(Manager.class);
    protected String name;
//    管理者的上级
    protected Manager superior;
//    设置管理者的上级
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }
    public abstract void requestApplication(Request request);
}
