package org.example;


import org.example.command.Invoker;
import org.example.entities.CollectionController;
import org.example.entities.HumanBeing;
import org.example.xmlParser.Reader;
import org.example.xmlParser.Writer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\fohad\\IdeaProjects\\LaboratoryWork5\\src\\main\\java\\org\\example\\lab5");
        Writer writer = new Writer();
        Reader reader = new Reader(file);
        List<HumanBeing> humanBeings = reader.getPersons();
        CollectionController cc = new CollectionController(humanBeings, writer, file);
        //   cc.addAll(humanBeings);
//        System.out.println(reader.getPersons());


        Invoker invoker = new Invoker(cc);
        invoker.readCommands();


        // String a = System.getenv("lab5");
        //System.out.println(a);
        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Неля\\IdeaProjects\\Lab5\\src\\lab5");
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);
        //int i;

        //while((i = bufferedInputStream.read())!= -1){
        //    System.out.print(i);
    }
    //public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
    //    XmlMapper xmlMapper = new XmlMapper();
    //    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Неля\\IdeaProjects\\Lab5\\src\\lab5");
    //    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);
    //    xmlMapper.readValue();
    //}
}
