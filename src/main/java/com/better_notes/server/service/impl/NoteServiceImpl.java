package com.better_notes.server.service.impl;

import com.better_notes.server.dto.note.NoteInsertDto;
import com.better_notes.server.dto.note.NoteResponseDto;
import com.better_notes.server.dto.note.NoteUpdateDto;
import com.better_notes.server.entity.Note;
import com.better_notes.server.exception.ResourceNotFoundException;
import com.better_notes.server.mapper.NoteMapper;
import com.better_notes.server.repository.NoteRepository;
import com.better_notes.server.service.interfaces.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;

    @Autowired
    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NoteResponseDto> getAllNotes(boolean isShort) {
        List<Note> notes;
        if (isShort) notes = repository.findAllByIsShortTrue();
        else notes = repository.findAllByIsShortFalse();
        return NoteMapper.toResponseDtoList(notes);
    }

    @Override
    public NoteResponseDto createNote(NoteInsertDto insertDto) {
        Note note = NoteMapper.toEntity(insertDto);
        note = repository.save(note);
        return NoteMapper.toResponseDto(note);
    }

    @Override
    public NoteResponseDto createShortNote(NoteInsertDto insertDto) {
        Note note = NoteMapper.toEntity(insertDto);
        note = repository.save(note);
        return NoteMapper.toResponseDto(note);
    }

    @Override
    public NoteResponseDto getNoteById(Long noteId) {
        Note note = repository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("A note with given id could not be found!: " + noteId));
        return NoteMapper.toResponseDto(note);
    }

    @Override
    public NoteResponseDto getNoteByExternalId(String externalId) {
        Note note = repository.findByExternalId(UUID.fromString(externalId))
                .orElseThrow(() -> new ResourceNotFoundException("A note with given externalId could not be found!: " + externalId));
        return NoteMapper.toResponseDto(note);
    }

    @Override
    public NoteResponseDto updateNoteById(NoteUpdateDto updateDto) {
        Note note = repository.findById(updateDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("A note with given id could not be found!: " + updateDto.getId()));
        if (updateDto.getTitle() != null && !updateDto.getTitle().isBlank()) note.setTitle(updateDto.getTitle());
        if (updateDto.getContent() != null && !updateDto.getContent().isBlank())
            note.setContent(updateDto.getContent());
        note = repository.save(note);
        return NoteMapper.toResponseDto(note);
    }

    @Override
    public NoteResponseDto updateNoteByExternalId(NoteUpdateDto updateDto, String externalId) {
        Note note = repository.findByExternalId(UUID.fromString(externalId))
                .orElseThrow(() -> new ResourceNotFoundException("A note with given externalId could not be found!: " + updateDto.getId()));
        if (updateDto.getTitle() != null && !updateDto.getTitle().isBlank()) note.setTitle(updateDto.getTitle());
        if (updateDto.getContent() != null && !updateDto.getContent().isBlank())
            note.setContent(updateDto.getContent());
        note = repository.save(note);
        return NoteMapper.toResponseDto(note);
    }

    @Override
    public void deleteNoteById(Long noteId) {
        Note note = repository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("A note with given noteId could not be found!: " + noteId));
        repository.delete(note);
    }

    @Override
    public void deleteNoteByExternalId(String externalId) {
        Note note = repository.findByExternalId(UUID.fromString(externalId))
                .orElseThrow(() -> new ResourceNotFoundException("A note with given externalId could not be found!: " + externalId));
        repository.delete(note);
    }
}
