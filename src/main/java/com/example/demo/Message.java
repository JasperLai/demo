package com.example.demo;

import java.io.StringWriter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;


@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
abstract public class Message {
    private String id;
    private Header header;
    private Body body;


    abstract public String toXml();
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Header getHeader() {
        return this.header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    // getters and setters

    public static void main(String[] args) {
        Message concreteMessage = new ConcreteMessage();
        concreteMessage.setId("123");
        concreteMessage.setHeader(new Header("123","456"));
        concreteMessage.setBody(new Body("Hello, World!"));

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ConcreteMessage.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Convert derived class to XML string
            String xmlString = marshalToXML(concreteMessage, marshaller);
            System.out.println(xmlString);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String marshalToXML(Object obj, Marshaller marshaller) throws JAXBException {
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
class ConcreteMessage extends Message {

    @Override
    public String toXml() {
       return null;
    }
    // Additional properties specific to ConcreteMessage

    // getters and setters
}

@XmlAccessorType(XmlAccessType.FIELD)
class Header {
    // Properties for Header
    private String from;
    private String to;

    public Header(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    // getters and setters
}

@XmlAccessorType(XmlAccessType.FIELD)
class Body {
    @XmlValue
    private String content;

    public Body() {
    }

    public Body(String content) {
        this.content = content;
    }

    // getters and setters
}

