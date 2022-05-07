package dev.phellipe.psicanalise.domain.validation;

import dev.phellipe.psicanalise.domain.exceptions.ValidationException;

import java.util.List;

public abstract class EntityValidation<T> {
    protected abstract void validate(T t);

    protected void exception(List<String> errors) {
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
