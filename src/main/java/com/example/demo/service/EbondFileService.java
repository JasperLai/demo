package com.example.demo.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
public class EbondFileService {

    // 返回值后续修改增加次数
    public void HandleOldFiles(File directory) {
        // List<ReportFile> reports = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Generate a new file for each file in the directory
                        generate(file);
                        // reports.add(generate(file));
                    } else if (file.isDirectory()) {
                        // Recursively process subdirectories
                        HandleOldFiles(file);
                    }
                }
            }
        }
        // return reports;
    }

    // 该方法属于protocol context
    private File generate(File srcfile) {
        String name = srcfile.getName();
        File destFile;
        if (name.contains("FSMX")) {
            destFile = new File(formatString("FSMX"));
            // convert 方法
            return destFile;

        } else if (name.contains("HZSJ")) {
            destFile = new File(formatString("HZSJ"));
            // convert 方法
            return destFile;

        } else if (name.contains("YWTJ")) {
            destFile = new File(formatString("YWTJ"));
            // convert 方法
            return destFile;

        } else if (name.contains("ZHBD")) {
            destFile = new File(formatString("ZHBD"));
            // convert 方法
            return destFile;

        } else if (name.contains("KHSJ")) {
            destFile = new File(formatString("KHSJ"));
            // convert 方法
            return destFile;

        } else {
            return null;

        }

    }

    private String formatString(String input) {
        // Add the prefix "0201"
        String formattedString = "0201" + input;

        // Get the current date in the format "yyyyMMdd"
        String currentDate = getCurrentDate();

        // Add the suffix representing the current date
        formattedString = formattedString + currentDate;

        return formattedString;
    }

    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }

}
