package com.better_notes.server.dto.note;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NoteResponseDto {
    private Long id;
    private UUID externalId;
    private String title;
    private String content;
    private boolean isShort;
    private boolean isDeleted;
    private LocalDateTime updatedAt;
}
