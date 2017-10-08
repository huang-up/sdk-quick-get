package design.pattern.chapter14.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by h on 2017/10/8.
 */
public class Boss extends Subject{
    private List<Observer> observerList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observerList) {
            observer.update();
        }
    }

}
