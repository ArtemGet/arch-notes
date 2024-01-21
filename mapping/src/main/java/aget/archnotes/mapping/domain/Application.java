package aget.archnotes.mapping.domain;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Application {
    private final UUID id;
    private final List<Stage> stages;
}
