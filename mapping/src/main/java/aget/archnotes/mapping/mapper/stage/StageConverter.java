package aget.archnotes.mapping.mapper.stage;

import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StageConverter
        extends Converter<Stage, StageDto> {

    @Override
    @Mapping(target = "applicationStageName", source = "stageName")
    StageDto convert(Stage source);
}
