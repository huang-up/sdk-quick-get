package com.huang.design.pattern.chapter23.command.example;

/**
 * Created by h on 2017/10/22.
 */
public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(String name, Barbecuer barbecuer) {
        super.name = name;
        super.barbecuer = barbecuer;
    }
    @Override
    public void executeCommand() {
        barbecuer.bakeChickenWing();
    }
}
