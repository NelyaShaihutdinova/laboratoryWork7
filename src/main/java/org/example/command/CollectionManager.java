package org.example.command;

import org.example.entities.HumanBeing;

import java.util.HashSet;
import java.util.Map;

public class CollectionManager {
    HashSet<HumanBeing> collection = new HashSet<>();
    public void add(HumanBeing humanBeing){
        collection.add(humanBeing);
    }

    public void show(){
        for (HumanBeing humanBeing : collection) {
            System.out.println(humanBeing);
        }
    }

    public void clear(){
        collection.clear();
    }

    public void info(){
        System.out.println("Тип: HashSet" + " Количество элементов: " + collection.size());
    }
//     public void help(){
//         for (Command c : commands.values()){
//             System.out.println(c.descr());
//         }
//     }
}
