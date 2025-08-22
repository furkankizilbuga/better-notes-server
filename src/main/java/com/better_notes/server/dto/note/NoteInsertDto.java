package com.better_notes.server.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NoteInsertDto {
    private String title;
    private String content;
    @JsonProperty("isShort")
    private boolean isShort = false;
}
