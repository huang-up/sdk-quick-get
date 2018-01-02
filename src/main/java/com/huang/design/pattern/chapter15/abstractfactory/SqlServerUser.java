package com.huang.design.pattern.chapter15.abstractfactory;

import org.apache.log4j.Logger;

/**
 * Created by h on 2017/10/13.
 */
public class SqlServerUser implements IUser {
    private static final Logger logger = Logger.getLogger(SqlServerUser.class);
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
