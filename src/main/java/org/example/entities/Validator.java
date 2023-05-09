package org.example.entities;

import org.example.exception.ValidException;

public interface Validator<T> {
    boolean checkElement(T object) throws ValidException;
}
