package org.myproject.service.validator;

public interface Validator<T> {
    boolean isValid(T object);
}
