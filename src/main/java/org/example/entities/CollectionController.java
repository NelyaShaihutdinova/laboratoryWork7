package org.example.entities;

import java.util.HashSet;
import java.util.List;

public class CollectionController {
    private HashSet<HumanBeing> collection = new HashSet<HumanBeing>();
    



    public HashSet<HumanBeing> getCollection() {
        return collection;
    }
    public void addAll(HumanBeings humanBeings) {

       collection.addAll(List.of(humanBeings.getHumanBeing()));
    }

}
