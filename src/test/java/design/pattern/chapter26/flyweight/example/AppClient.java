package design.pattern.chapter26.flyweight.example;

/**
 * Created by h on 2017/10/25.
 */
public class AppClient {
    public static void main(String[] args) {
        WebsiteFactory f = new WebsiteFactory();

        Website fx = f.getWebsiteCategory("产品展示");
        fx.use(new User("小菜"));

        Website fy = f.getWebsiteCategory("产品展示");
        fy.use(new User("大鸟"));

        Website fz = f.getWebsiteCategory("产品展示");
        fz.use(new User("娇娇"));

        Website fl = f.getWebsiteCategory("博客");
        fl.use(new User("老顽童"));

        Website fm = f.getWebsiteCategory("博客");
        fm.use(new User("桃谷六仙"));

        Website fn = f.getWebsiteCategory("博客");
        fn.use(new User("南海鳄神"));

        int count = f.getWebsiteCount();
        System.out.println("网站分类总数：" + count);
    }
}
