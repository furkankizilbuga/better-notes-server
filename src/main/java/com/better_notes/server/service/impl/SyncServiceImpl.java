package com.better_notes.server.service.impl;

import com.better_notes.server.dto.sync.NoteSyncRequestDto;
import com.better_notes.server.dto.sync.NoteSyncResponseDto;
import com.better_notes.server.entity.Note;
import com.better_notes.server.mapper.NoteMapper;
import com.better_notes.server.repository.NoteRepository;
import com.better_notes.server.service.interfaces.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SyncServiceImpl implements SyncService {
    private final NoteRepository noteRepository;

    @Autowired
    public SyncServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void applyNoteChanges(List<NoteSyncRequestDto> changes) {
        for (NoteSyncRequestDto dto : changes) {
            Optional<Note> found = noteRepository.findByExternalId(dto.getExternalId());
            if (found.isEmpty()) {
                // New note:
                Note note = NoteMapper.toEntity(dto);
                noteRepository.save(note);
            } else {
                Note existing = found.get();
                // So as not to experience any conflict. Always write the last.
                if (dto.getUpdatedAt().isAfter(existing.getUpdatedAt())) {
                    Note note = NoteMapper.toEntity(dto);
                    noteRepository.save(note);
                }
            }
        }
    }

    @Override
    public List<NoteSyncResponseDto> getNoteChangesSince(LocalDateTime since) {
        return noteRepository.findAllByUpdatedAtAfter(since)
                .stream()
                .map(NoteMapper::toSyncResponseDto)
                .collect(Collectors.toList());
    }
}
