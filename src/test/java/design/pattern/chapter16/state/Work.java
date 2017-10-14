package design.pattern.chapter16.state;

/**
 * Created by h on 2017/10/14.
 */
public class Work {
    private int hour;
    private boolean taskFinished;
    private State currentState;

    public Work() {
        this.currentState = new ForenoonState();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void writeProgram() {
        currentState.writeProgram(this);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isTaskFinished() {
        return taskFinished;
    }

    public void setTaskFinished(boolean taskFinished) {
        this.taskFinished = taskFinished;
    }
}
