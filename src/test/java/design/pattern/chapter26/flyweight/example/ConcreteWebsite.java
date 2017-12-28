package design.pattern.chapter26.flyweight.example;

/**
 * Created by h on 2017/10/25.
 */
public class ConcreteWebsite extends Website {
    private String name = "";
    public ConcreteWebsite(String name) {
        this.name = name;
    }
    @Override
    public void use(User user) {
        super.logger.info("网站分类：" + name + " 用户：" + user.getName());
    }
}
