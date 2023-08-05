package com.example.demo.model.Report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportFile {
    private List<Node> content; // 内容对象
    private File outputFile; // 对应文件
    private int sendStatus; // 发送状态
    private String sendId; // 中债返回 ID

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public int getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(int sendStatus) {
        this.sendStatus = sendStatus;
    }

    private static final Logger logger = LogManager.getLogger(ReportFile.class);

    public ReportFile() {
    }

    public boolean fromFile(File f) {
        // 读取文件，并按照旧文件解析，生成 List<Node>
        String name = f.getName();
        content = new ArrayList<Node>();
        List<String> oldData;
        try {
            oldData = Files.readAllLines(f.toPath());
            if (name.contains("FSMX")) {
                for (String s : oldData) {
                    
                }
            } else if (name.contains("HZSJ")) {

            } else if (name.contains("YWTJ")) {

            } else if (name.contains("ZHBD")) {

            } else if (name.contains("KHSJ")) {

            } else {

            }
        } catch (IOException e) {
            logger.info("Error reading lines from file: " + e.getMessage());
        }
        return true;
    }

    // public void fromRepo(Repository repo){

    // }

    // public void fromFacade(Facade fa){

    // }

    public List<Node> getContent() {
        return this.content;
    }

    public void setContent(List<Node> content) {
        this.content = content;
    }

    public File getOutputFile() {
        return this.outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public File toFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Node node : content) {
                writer.write(node.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            logger.info("Error writing strings to file: " + e.getMessage());
        }
        return outputFile;
    }

}
