package com.better_notes.server.mapper;

import com.better_notes.server.dto.note.NoteInsertDto;
import com.better_notes.server.dto.note.NoteResponseDto;
import com.better_notes.server.dto.note.NoteUpdateDto;
import com.better_notes.server.dto.sync.NoteSyncRequestDto;
import com.better_notes.server.dto.sync.NoteSyncResponseDto;
import com.better_notes.server.entity.Note;
import java.util.List;

public class NoteMapper {

    public static NoteResponseDto toResponseDto(Note note) {
        NoteResponseDto dto = new NoteResponseDto();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setShort(note.isShort());
        return dto;
    }

    public static NoteSyncResponseDto toSyncResponseDto(Note note) {
        NoteSyncResponseDto dto = new NoteSyncResponseDto();
        dto.setExternalId(note.getExternalId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setShort(note.isShort());
        dto.setDeleted(note.isDeleted());
        dto.setUpdatedAt(note.getUpdatedAt());
        return dto;
    }

    public static List<NoteResponseDto> toResponseDtoList(List<Note> notes) {
        return notes.stream().map(NoteMapper::toResponseDto).toList();
    }

    public static Note toEntity(NoteInsertDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setShort(dto.isShort());
        return note;
    }

    public static Note toEntity(NoteUpdateDto dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setShort(dto.isShort());
        return note;
    }

    public static Note toEntity(NoteSyncRequestDto dto) {
        Note note = new Note();
        note.setExternalId(dto.getExternalId());
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setShort(dto.isShort());
        note.setDeleted(dto.isDeleted());
        note.setUpdatedAt(dto.getUpdatedAt());
        return note;
    }
}
