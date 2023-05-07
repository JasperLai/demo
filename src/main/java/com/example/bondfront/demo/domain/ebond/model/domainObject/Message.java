package com.example.bondfront.demo.domain.ebond.model.domainObject;


public abstract class Message {

    private String id;
    private String header;
    private String body;

    public Message(String id) {
        this.id = id;
        header = createHeader();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private  String createHeader(){
        //todo 创建header, 生成msgId，创建时间，重发标识
        return null;
    }
    abstract void createBody();



    public String toXML() throws Exception {
       
        return null;
    }
}
