package com.huang.design.pattern.chapter14.observer;

/**
 * Created by h on 2017/10/8.
 */
public abstract class Subject {
    private String subjectState;
    public abstract void attach(Observer observer);
    public abstract void detach(Observer observer);
    public abstract void notifyObservers();

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
