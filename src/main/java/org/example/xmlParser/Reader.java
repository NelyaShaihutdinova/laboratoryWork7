package org.example.xmlParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.entities.HumanBeings;

import java.io.*;

//@JacksonXmlElementWrapper
public class Reader {
    private File file;
    public Reader(File file) {
        this.file = file;
    }

    public HumanBeings getPersons() {
        return parsingPersonsFromXml(readFileToString(file));
    }

    private String readFileToString(File file) {
        byte[] data;
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            data = inputStream.readAllBytes();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
        return new String(data);
    }

    private HumanBeings parsingPersonsFromXml(String data) {
        XmlMapper xmlmapper = new XmlMapper();
        try {
            HumanBeings humanBeings = xmlmapper.readValue(data, HumanBeings.class);
            return humanBeings;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return new HumanBeings();
        }
    }
}