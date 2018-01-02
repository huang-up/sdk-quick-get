package com.huang.design.pattern.chapter19.composite;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by h on 2017/10/19.
 */
public class Composite extends Component {
    private List<Component> childrens = new ArrayList<Component>();
    public Composite(String name) {
        super.name = name;
    }
    @Override
    public void add(Component component) {
        this.childrens.add(component);
    }

    @Override
    public void remove(Component component) {
        this.childrens.remove(component);
    }

    @Override
    public void display(int depth) {

        super.logger.info(StringUtils.join(StringUtils.rightPad("-", depth, '-'), super.name));
        for (Component component:childrens) {
            component.display(depth+2);
        }
    }
}
