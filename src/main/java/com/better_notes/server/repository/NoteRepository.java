package com.better_notes.server.repository;

import com.better_notes.server.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByIsShortFalse();
    List<Note> findAllByIsShortTrue();
    Optional<Note> findByExternalId(UUID externalId);
    List<Note> findAllByUpdatedAtAfter(LocalDateTime since);
}
