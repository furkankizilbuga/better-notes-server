package com.better_notes.server.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteUpdateDto {
    @NotNull
    private Long id;
    private String title;
    private String content;
    @JsonProperty("isShort")
    private boolean isShort = false;
}
