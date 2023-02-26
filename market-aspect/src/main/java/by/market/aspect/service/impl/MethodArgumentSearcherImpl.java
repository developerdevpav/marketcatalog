package by.market.aspect.service.impl;

import by.market.aspect.service.MethodArgumentSearcher;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MethodArgumentSearcherImpl implements MethodArgumentSearcher {

    @Override
    public Object findByAnnotation(final Parameter[] parameters,
                                   final Object[] objects,
                                   final Class<? extends Annotation> annotation) {
        final var indexes = getIndexParameterByAnnotation(parameters, annotation);

        if (indexes.isEmpty()) {
            return null;
        }

        final int firstElement = indexes.get(0);

        final boolean indexIsOffBoundArray = (firstElement < objects.length && firstElement > 0);

        if (indexIsOffBoundArray) {
            return null;
        }

        return objects[firstElement];
    }

    @Override
    public List<Object> findAllByAnnotation(final Parameter[] parameters,
                                            final Object[] objects,
                                            final Class<? extends Annotation> annotation) {
        final var indexes = getIndexParameterByAnnotation(parameters, annotation);

        if (indexes.isEmpty()) {
            return null;
        }

        return indexes.stream()
                .filter(index -> index < objects.length && index >= 0)
                .map(index -> objects[index])
                .collect(Collectors.toList());
    }

    private List<Integer> getIndexParameterByAnnotation(final Parameter[] parameters,
                                                        final Class<? extends Annotation> annotationClass) {
        final var indexes = new ArrayList<Integer>();

        for (int i = 0; i < parameters.length; i++) {
            final var parameter = parameters[i];

            final boolean parameterContainsAnnotation = Arrays.stream(parameter.getAnnotations())
                    .anyMatch(annotation -> annotation.annotationType().equals(annotationClass));

            if (parameterContainsAnnotation) {
                indexes.add(i);
            }
        }

        return indexes;
    }

}
