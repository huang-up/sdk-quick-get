package design.pattern.chapter24.chainofresponsibility.example;

/**
 * Created by h on 2017/10/23.
 */
public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super.name = name;
    }
    @Override
    public void requestApplication(Request request) {
        if ("请假".equals(request.getType())) {
            super.logger.info(String.format("%s: %s 数量 %d 被批准",
                    this.getClass().getName(), request.getContent(), request.getNumber()));
        } else if ("加薪".equals(request.getType()) && request.getNumber() <= 500) {
            super.logger.info(String.format("%s: %s 数量 %d 被批准",
                    this.getClass().getName(), request.getContent(), request.getNumber()));
        } else if ("加薪".equals(request.getType()) && request.getNumber() > 500) {
            super.logger.info(String.format("%s: %s 数量 %d 再说吧",
                    this.getClass().getName(), request.getContent(), request.getNumber()));
        }
    }
}
