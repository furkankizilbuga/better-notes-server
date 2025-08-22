package com.better_notes.server.dto.note;

import lombok.Data;

@Data
public class NoteResponseDto {
    //TODO: Should Id be returned?
    private Long id;
    private String title;
    private String content;
    private boolean isShort;
}
