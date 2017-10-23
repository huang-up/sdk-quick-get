package design.pattern.chapter24.chainofresponsibility.example;


/**
 * Created by h on 2017/10/23.
 */
public class AppClient {
    public static void main(String[] args) {
        CommanManager jinli = new CommanManager("金利");
        Majordomo zongjian = new Majordomo("宗剑");
        GeneralManager zhongjingli = new GeneralManager("钟精励");
        jinli.setSuperior(zongjian);
        zongjian.setSuperior(zhongjingli);

        Request request = new Request();
        request.setType("请假");
        request.setContent("小菜请假");
        request.setNumber(1);
        jinli.requestApplication(request);

        Request request1 = new Request();
        request.setType("请假");
        request.setContent("小菜请假");
        request.setNumber(4);
        jinli.requestApplication(request);

        Request request2 = new Request();
        request.setType("加薪");
        request.setContent("小菜请求加薪");
        request.setNumber(500);
        jinli.requestApplication(request);

        Request request3 = new Request();
        request.setType("加薪");
        request.setContent("小菜请求加薪");
        request.setNumber(1000);
        jinli.requestApplication(request);
     }
}
