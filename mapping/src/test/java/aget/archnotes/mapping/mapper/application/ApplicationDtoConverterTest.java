package aget.archnotes.mapping.mapper.application;

import aget.archnotes.mapping.domain.Application;
import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.ApplicationDto;
import aget.archnotes.mapping.dto.StageDto;
import aget.archnotes.mapping.mapper.stage.StageConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ApplicationDtoConverterTest {
    @InjectMocks
    ApplicationDtoConverter converter = Mappers.getMapper(ApplicationDtoConverter.class);
    @Spy
    StageConverter stageConverter;

    @Test
    void convert_shouldConvert_whenNotNull() {
        UUID id = UUID.randomUUID();
        List<Stage> stages = List.of(new Stage("start"),
                new Stage("end"));

        Application application = new Application(id, stages);

        Mockito.when(stageConverter.convert(new Stage("start")))
                .thenReturn(new StageDto("start"));
        Mockito.when(stageConverter.convert(new Stage("end")))
                .thenReturn(new StageDto("end"));

        ApplicationDto expected
                = new ApplicationDto(id,
                List.of(new StageDto("start"),
                        new StageDto("end")));

        Assertions.assertEquals(expected, converter.convert(application));
    }
}
