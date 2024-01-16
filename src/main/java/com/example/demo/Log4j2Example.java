package com.example.demo;


import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j2Example {

    private static final Logger logger = LogManager.getLogger(Log4j2Example.class);

    
    public static void main(String[] args) {
        File file = new File("/user/abc/test.txt");

        // Get the parent directory of the file
        String parentDirectory = file.getParent();

        if (parentDirectory != null) {
            System.out.println("Parent Directory: " + parentDirectory);
        } else {
            System.out.println("No parent directory (root or file doesn't exist).");
        }
    }
}

