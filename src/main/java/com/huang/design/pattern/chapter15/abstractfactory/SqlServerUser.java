package com.huang.design.pattern.chapter15.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by h on 2017/10/13.
 */
public class SqlServerUser implements IUser {
    private static final Logger logger = LoggerFactory.getLogger(SqlServerUser.class);
    @Override
    public void insert(User user) {
        logger.info("insert sqlserver user");
    }

    @Override
    public User getuser(int id) {
        logger.info("get sqlserver user");
        return null;
    }
}
