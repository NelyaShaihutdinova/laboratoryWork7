package org.example.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.StringJoiner;

@JacksonXmlRootElement(localName = "HumanBeings")
public class HumanBeings {

    @JacksonXmlElementWrapper(localName = "humanBeing", useWrapping = false)
    HumanBeing[] humanBeing;

    public HumanBeings() {}

    public HumanBeings(HumanBeing[] humanBeing) {
        this.humanBeing = humanBeing;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (HumanBeing k:humanBeing) {
            stringBuilder.append(k.getId()).append(" ").append(k.getName());
        }
        return stringBuilder.toString();
    }

    public HumanBeing[] getHumanBeing() {
        return humanBeing;
    }
}
