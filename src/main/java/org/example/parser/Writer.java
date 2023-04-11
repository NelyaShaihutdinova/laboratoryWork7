package org.example.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer<T> {
    private final XmlMapper xmlMapper = new XmlMapper();

    public String parsingPersonsToXml(List<T> collection) {
        try {
            String data;
            xmlMapper.registerModule(new JavaTimeModule());
            data = xmlMapper.writeValueAsString(collection);
            return data;
        } catch (IOException e) {
            System.out.println("exception");
            return "";
        }
    }

    public void writeCollectionToFile(String data, File file) {
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(file));
            writter.write(data);
            writter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


