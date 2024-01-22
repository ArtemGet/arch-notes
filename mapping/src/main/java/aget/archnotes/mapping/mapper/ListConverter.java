package aget.archnotes.mapping.mapper;

import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public interface ListConverter<S, T> extends Converter<S, T> {
    default List<T> convertList(List<S> sources) {
        return sources.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
