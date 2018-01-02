package com.huang.design.pattern.chapter23.command.example;

/**
 * Created by h on 2017/10/22.
 */
public class AppClient {
    public static void main(String[] args) {
        Barbecuer barbecuer = new Barbecuer();
        Command bakeMuttonCommand = new BakeMuttonCommand("烤羊肉", barbecuer);
        Command bakeMuttonCommand1 = new BakeMuttonCommand("烤羊肉", barbecuer);
        Command bakeChickenWingCommand = new BakeChickenWingCommand("烤鸡翅", barbecuer);
        Waiter girl = new Waiter();
        girl.setOrder(bakeMuttonCommand);
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeChickenWingCommand);
        girl.notifyExecute();
    }
}
