package by.market.aspect.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.List;

public interface MethodArgumentSearcher {

    Object findByAnnotation(final Parameter[] parameters,
                            final Object[] objects,
                            final Class<? extends Annotation> annotation);

    List<Object> findAllByAnnotation(final Parameter[] parameters,
                                     final Object[] objects,
                                     final Class<? extends Annotation> annotation);

}
