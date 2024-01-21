package aget.archnotes.mapping.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ApplicationDto {
    private final UUID id;
    private final List<StageDto> stages;
}
