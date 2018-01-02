package com.huang.design.pattern.chapter19.composite;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by h on 2017/10/19.
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super.name = name;
    }
    @Override
    public void add(Component component) {
        super.logger.info("can't add to a leaf");
    }

    @Override
    public void remove(Component component) {
        super.logger.info("can't remove to a leaf");
    }

    @Override
    public void display(int depth) {
        super.logger.info(StringUtils.join(StringUtils.rightPad("-", depth, '-'), super.name));
    }
}
