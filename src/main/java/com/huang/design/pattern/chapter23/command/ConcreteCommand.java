package com.huang.design.pattern.chapter23.command;

/**
 * Created by h on 2017/10/22.
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super.receiver = receiver;
    }

    @Override
    public void executeCommand() {
        receiver.action();
    }
}
