package aget.archnotes.mapping;

import aget.archnotes.mapping.domain.Application;
import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.ApplicationDto;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.dto.ApplicationLastStageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;

@SpringBootTest
class MappingApplicationTests {
    @Autowired
    ConversionService conversionService;

    @Test
    void contextLoads() {}

    @Test
    void canConvert_shouldConvertApplicationEntity_whenContextLoads() {
        Assertions.assertTrue(
                conversionService.canConvert(Application.class, ApplicationDto.class));

        Assertions.assertTrue(
                conversionService.canConvert(Application.class, ApplicationLastStageDto.class));
    }

    @Test
    void canConvert_shouldConvertApplicationStageEntity_whenContextLoads() {
        Assertions.assertTrue(
                conversionService.canConvert(Stage.class, StageDto.class));
    }
}
