package com.better_notes.server.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteUpdateDto {
    private Long id;
    @NotNull
    private UUID externalId;
    private String title;
    private String content;
    @JsonProperty("isShort")
    private boolean isShort = false;
    private boolean isDeleted = false;
}
