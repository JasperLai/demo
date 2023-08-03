package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {

    private static final Logger logger = LogManager.getLogger(Log4j2Example.class);

    public static void main(String[] args) {
        logger.debug("This is a debug .");
        logger.info("This is an info .");
        logger.warn("This is a warning .");
        logger.error("This is an error ls.");
    }
}

