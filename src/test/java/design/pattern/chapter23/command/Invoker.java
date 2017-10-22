package design.pattern.chapter23.command;

/**
 * Created by h on 2017/10/22.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        this.command.executeCommand();
    }
}
