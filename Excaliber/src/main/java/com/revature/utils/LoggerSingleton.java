package com.revature.utils;

import org.apache.log4j.Logger;

public class LoggerSingleton {

    private static Logger logger;


    private static LoggerSingleton loggerSingleton;


    private LoggerSingleton() {

    }


    /**
     * Gets logger.
     *
     * @param c
     * @return Value of logger.
     */
    public static Logger getLogger(Class c) {
        logger = Logger.getLogger(c);
        if (loggerSingleton == null) {
            loggerSingleton = new LoggerSingleton();
            logger.info("created singleton: Logger");
        }
        return logger;
    }
}
