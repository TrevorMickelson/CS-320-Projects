package org.snhu.services;

import org.snhu.services.validators.Validator;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class Service<T, K extends Validator> {
    private final Map<String, T> objectMap = new HashMap<>();
    private final K validator;

    public Service(K validator) {
        this.validator = validator;
    }

    public void add(String id, T object) {
        if (!validator.isValid()) {
            throw new InvalidParameterException("Error: Input Invalid!");
        }

        objectMap.putIfAbsent(id, object);
    }

    public void remove(String id) {
        objectMap.remove(id);
    }

    public void update(String id, Consumer<T> objectConsumer) {
        T object = objectMap.get(id);
        objectConsumer.accept(object);
    }

    public int size() {
        return objectMap.size();
    }

    public Optional<T> get(String id) {
        return Optional.ofNullable(objectMap.get(id));
    }
}
