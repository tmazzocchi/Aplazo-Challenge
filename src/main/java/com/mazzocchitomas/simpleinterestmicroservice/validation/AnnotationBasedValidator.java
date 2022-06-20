package com.mazzocchitomas.simpleinterestmicroservice.validation;

import java.util.function.Consumer;

@FunctionalInterface
public interface AnnotationBasedValidator extends Consumer<Object> {

    @Override
    void accept(final Object object);
}
