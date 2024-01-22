package aget.archnotes.mapping.service;

import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.mapper.ListConverter;
import aget.archnotes.mapping.mapper.stage.StageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {
    private final ConversionService conversionService;
    private final Converter<Stage, StageDto> stageConverter;
    private final ListConverter<Stage, StageDto> stageStageDtoListConverter;

    @Autowired
    public ExampleService(ConversionService conversionService,
                          StageConverter stageConverter,
                          ListConverter<Stage, StageDto> stageStageDtoListConverter) {
        this.conversionService = conversionService;
        this.stageConverter = stageConverter;
        this.stageStageDtoListConverter = stageStageDtoListConverter;
    }

    public StageDto exampleMappingStageViaConversionService(Stage stage) {
        return conversionService.convert(stage, StageDto.class);
    }

    public StageDto exampleMappingStageViaDirectConverter(Stage stage) {
        return stageConverter.convert(stage);
    }

    public StageDto exampleMappingStageViaDirectListConverter(Stage stage) {
        return stageStageDtoListConverter.convert(stage);
    }

    public List<StageDto> exampleMappingStagesViaDirectListConverter(List<Stage> stages) {
        return stageStageDtoListConverter.convertList(stages);
    }
}
