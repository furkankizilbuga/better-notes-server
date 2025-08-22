package com.better_notes.server.service.interfaces;

import com.better_notes.server.dto.note.NoteInsertDto;
import com.better_notes.server.dto.note.NoteResponseDto;
import com.better_notes.server.dto.note.NoteUpdateDto;

import java.util.List;

public interface NoteService {
    List<NoteResponseDto> getAllNotes(boolean isShort);
    NoteResponseDto createNote(NoteInsertDto insertDto);
    NoteResponseDto createShortNote(NoteInsertDto insertDto);
    NoteResponseDto getNoteById(Long noteId);
    NoteResponseDto updateNoteById(NoteUpdateDto updateDto);
    void deleteNoteById(Long noteId);
}
