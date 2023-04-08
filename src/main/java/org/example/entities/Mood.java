package org.example.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public enum Mood {

    @JacksonXmlProperty(localName = "1")
    M1,
    @JacksonXmlProperty(localName = "2")
    M2,
    @JacksonXmlProperty(localName = "3")
    M3,
    @JacksonXmlProperty(localName = "4")
    M4;
    public static Mood fromInteger(int x) {
        switch(x) {
            case 1:
                return M1;
            case 2:
                return M2;
            case 3:
                return M3;
            case 4:
                return M4;
        }
        return null;
    }
}
