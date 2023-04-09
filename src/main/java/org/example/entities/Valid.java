package org.example.entities;

import org.example.exception.ValidException;

public interface Valid {
    boolean isValid() throws ValidException;
}
