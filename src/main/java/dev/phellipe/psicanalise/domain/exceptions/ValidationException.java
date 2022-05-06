package dev.phellipe.psicanalise.domain.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException{
    public ValidationException(List<String> erros){
        super(String.join("\n", erros));
    }
}
