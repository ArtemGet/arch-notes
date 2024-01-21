package aget.archnotes.mapping.mapper.application;

import aget.archnotes.mapping.domain.Application;
import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.dto.ApplicationLastStageDto;
import aget.archnotes.mapping.mapper.stage.StageConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ApplicationLastStageConverter
        implements Converter<Application, ApplicationLastStageDto> {
    @Autowired
    protected StageConverter stageConverter;

    @Override
    @Mapping(target = "lastStage", source = "stages", qualifiedByName = "convertLastStage")
    public abstract ApplicationLastStageDto convert(Application source);

    @Named(value = "convertLastStage")
    public StageDto convertLastStage(List<Stage> stages) {
        if (stages == null || stages.isEmpty()) {
            return null;
        }

        return stageConverter.convert(stages.get(stages.size() - 1));
    }
}
