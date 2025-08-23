package com.better_notes.server.controller;

import com.better_notes.server.dto.sync.NoteSyncRequestDto;
import com.better_notes.server.dto.sync.NoteSyncResponseDto;
import com.better_notes.server.service.interfaces.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sync")
public class SyncController {
    private final SyncService syncService;

    @Autowired
    public SyncController(SyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping("/notes/upload")
    public ResponseEntity<Void> uploadNotes(@RequestBody List<NoteSyncRequestDto> changes) {
        syncService.applyNoteChanges(changes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/notes/download")
    public ResponseEntity<List<NoteSyncResponseDto>> downloadNotes(@RequestParam String since) {
        LocalDateTime lastSync = LocalDateTime.parse(since);
        List<NoteSyncResponseDto> changes = syncService.getNoteChangesSince(lastSync);
        return new ResponseEntity<>(changes, HttpStatus.OK);
    }
}
