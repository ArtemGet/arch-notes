package aget.archnotes.mapping.mapper.stage;

import aget.archnotes.mapping.domain.Stage;
import aget.archnotes.mapping.dto.StageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class StageConverterTest {
    StageConverter converter = Mappers.getMapper(StageConverter.class);

    @Test
    void convert_shouldConvertAllFields_whenNotNull() {
        Stage stage = new Stage("start");

        StageDto expected = new StageDto("start");

        Assertions.assertEquals(expected, converter.convert(stage));
    }
}
