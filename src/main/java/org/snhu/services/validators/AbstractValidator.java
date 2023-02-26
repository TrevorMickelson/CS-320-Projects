package org.snhu.services.validators;

public abstract class AbstractValidator<T> implements Validator {
    protected final T object;

    public AbstractValidator(T object) {
        this.object = object;
    }

    public boolean isStringNotNullAndWithinLength(String s, int length) {
        return s != null && s.length() <= length;
    }
}
