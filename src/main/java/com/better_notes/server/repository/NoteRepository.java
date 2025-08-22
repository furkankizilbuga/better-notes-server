package com.better_notes.server.repository;

import com.better_notes.server.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByIsShortFalse();
    List<Note> findAllByIsShortTrue();
}
