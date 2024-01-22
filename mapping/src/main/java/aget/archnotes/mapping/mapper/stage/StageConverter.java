package aget.archnotes.mapping.mapper.stage;

import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.mapper.ListConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StageConverter
        extends ListConverter<Stage, StageDto> {

    @Override
    @Mapping(target = "applicationStageName", source = "stageName")
    StageDto convert(Stage source);
}
