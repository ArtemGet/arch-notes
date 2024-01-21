package aget.archnotes.mapping.mapper.application;

import aget.archnotes.mapping.domain.Application;
import aget.archnotes.mapping.dto.ApplicationDto;
import aget.archnotes.mapping.mapper.stage.StageConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = StageConverter.class)
public interface ApplicationDtoConverter
        extends Converter<Application, ApplicationDto> {

    @Override
    ApplicationDto convert(Application source);
}
