package org.example.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public enum WeaponType {
    @JacksonXmlProperty(localName = "1")
    W1,
    @JacksonXmlProperty(localName = "2")
    W2,
    @JacksonXmlProperty(localName = "3")
    W3;

    public static WeaponType fromInteger(int x) {
        switch (x) {
            case 1:
                return W1;
            case 2:
                return W2;
            case 3:
                return W3;
        }
        return null;
    }
}
