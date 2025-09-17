package com.better_notes.server.controller;

import com.better_notes.server.dto.note.NoteInsertDto;
import com.better_notes.server.dto.note.NoteResponseDto;
import com.better_notes.server.dto.note.NoteUpdateDto;
import com.better_notes.server.service.interfaces.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteResponseDto>> getAllNotes(@RequestParam(required = false, defaultValue = "false") boolean isShort) {
        List<NoteResponseDto> notes = noteService.getAllNotes(isShort);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<NoteResponseDto> getNoteByExternalId(@RequestParam String externalId) {
        NoteResponseDto responseDto = noteService.getNoteByExternalId(externalId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NoteResponseDto> createNote(@RequestBody NoteInsertDto insertDto) {
         NoteResponseDto responseDto = noteService.createNote(insertDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<NoteResponseDto> updateNoteByExternalId(@RequestParam String externalId, @RequestBody NoteUpdateDto updateDto) {
        NoteResponseDto responseDto = noteService.updateNoteByExternalId(updateDto, externalId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNoteByExternalId(@RequestParam String externalId) {
        noteService.deleteNoteByExternalId(externalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@PutMapping("/{noteId}")
    public ResponseEntity<NoteResponseDto> updateNoteById(@RequestBody NoteUpdateDto updateDto) {
        NoteResponseDto responseDto = noteService.updateNoteById(updateDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteResponseDto> getNoteById(@PathVariable Long noteId) {
        NoteResponseDto responseDto = noteService.getNoteById(noteId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }*/
}
