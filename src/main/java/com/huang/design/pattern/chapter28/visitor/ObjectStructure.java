package com.huang.design.pattern.chapter28.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by h on 2017/10/28.
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<Element>();
    public void attach(Element element) {
        elements.add(element);
    }
    public void detach(Element element) {
        elements.remove(element);
    }
    public void accept(Vistor vistor) {
        for (Element element:elements) {
            element.accept(vistor);
        }
    }
}
