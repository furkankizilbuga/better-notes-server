package com.better_notes.server.service.interfaces;

import com.better_notes.server.dto.sync.NoteSyncRequestDto;
import com.better_notes.server.dto.sync.NoteSyncResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface SyncService {
    void applyNoteChanges(List<NoteSyncRequestDto> changes);
    List<NoteSyncResponseDto> getNoteChangesSince(LocalDateTime since);
}
