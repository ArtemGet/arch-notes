package aget.archnotes.mapping.mapper.application;

import aget.archnotes.mapping.domain.Application;
import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.dto.ApplicationLastStageDto;
import aget.archnotes.mapping.mapper.stage.StageConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class ApplicationLastStageConverterTest {
    @InjectMocks
    ApplicationLastStageConverter converter = Mappers.getMapper(ApplicationLastStageConverter.class);
    @Spy
    StageConverter stageConverter;

    @Test
    void convert_shouldConvertAllFields_whenNotNull() {
        UUID id = UUID.randomUUID();
        List<Stage> stages = List.of(new Stage("start"),
                new Stage("end"));

        Application application = new Application(id, stages);

        Mockito.when(stageConverter.convert(new Stage("end")))
                .thenReturn(new StageDto("end"));

        ApplicationLastStageDto expected
                = new ApplicationLastStageDto(id, new StageDto("end"));

        Assertions.assertEquals(expected, converter.convert(application));
    }

    @Test
    void convertLastStage_shouldConvertLastStage_whenNotEmpty() {
        List<Stage> stages = List.of(new Stage("start"),
                new Stage("end"));

        Mockito.when(stageConverter.convert(new Stage("end")))
                .thenReturn(new StageDto("end"));

        StageDto expected = new StageDto("end");

        Assertions.assertEquals(expected, converter.convertLastStage(stages));
    }

    @Test
    void convertLastStage_shouldReturnNull_whenEmpty() {
        Assertions.assertNull(converter.convertLastStage(List.of()));
    }

    @Test
    void convertLastStage_shouldReturnNull_whenNull() {
        Assertions.assertNull(converter.convertLastStage(null));
    }
}
