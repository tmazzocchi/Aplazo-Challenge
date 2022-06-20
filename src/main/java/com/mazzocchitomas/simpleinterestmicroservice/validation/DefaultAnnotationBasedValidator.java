package com.mazzocchitomas.simpleinterestmicroservice.validation;

import com.mazzocchitomas.simpleinterestmicroservice.exception.ValidatorException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultAnnotationBasedValidator implements AnnotationBasedValidator {

    @Override
    public void accept(@NonNull final Object object) {
        Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(object)
                .stream()
                .map(v -> v.getMessage() + " ; " + "value " + v.getInvalidValue() + " invalid")
                .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::of))
                .filter(l -> l.size() > 0)
                .ifPresent(violations -> {
                    throw new ValidatorException("Input error validation", violations);
                });
    }
}
