package com.example.demo.model.Report;

public abstract class Node {
    
    private String delimiter = "!^"; //定义field之间的分隔符
    

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }


    abstract public String  getValue();
    
}
