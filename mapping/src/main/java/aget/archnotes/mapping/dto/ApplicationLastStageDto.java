package aget.archnotes.mapping.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ApplicationLastStageDto {
    private final UUID id;
    private final StageDto lastStage;
}
