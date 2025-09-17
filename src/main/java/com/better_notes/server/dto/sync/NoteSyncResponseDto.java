package com.better_notes.server.dto.sync;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteSyncResponseDto {
    private UUID externalId;
    private String title;
    private String content;
    private boolean isShort;
    private boolean isDeleted;
    private LocalDateTime updatedAt;
}
