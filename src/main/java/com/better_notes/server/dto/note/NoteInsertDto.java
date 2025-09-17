package com.better_notes.server.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class NoteInsertDto {
    private String title;
    private String content;
    private UUID externalId;
    @JsonProperty("isShort")
    private boolean isShort = false;
}
