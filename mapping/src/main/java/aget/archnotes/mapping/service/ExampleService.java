package aget.archnotes.mapping.service;

import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.mapper.stage.StageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private final ConversionService conversionService;
    private final StageConverter stageConverter;

    @Autowired
    public ExampleService(ConversionService conversionService,
                          StageConverter stageConverter) {
        this.conversionService = conversionService;
        this.stageConverter = stageConverter;
    }

    public StageDto exampleMappingStageViaConversionService(Stage stage) {
        return conversionService.convert(stage, StageDto.class);
    }

    public StageDto exampleMappingStageViaDirectConverter(Stage stage) {
        return stageConverter.convert(stage);
    }
}
