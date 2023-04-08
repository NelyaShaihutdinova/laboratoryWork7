package org.example.xmlParser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer<T> {
    private final XmlMapper xmlMapper = new XmlMapper();

    //хочу засунуть сериализованную коллекцию в массив, а потом этот массив через BufferedWriter впихуть в файл
    public String parsingPersonsToXml(List<T> collection) {
        try {
            String data;
            data = xmlMapper.writeValueAsString(collection);
            return data;
        } catch (IOException e) {
            System.out.println("exception");
            return new String();
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



