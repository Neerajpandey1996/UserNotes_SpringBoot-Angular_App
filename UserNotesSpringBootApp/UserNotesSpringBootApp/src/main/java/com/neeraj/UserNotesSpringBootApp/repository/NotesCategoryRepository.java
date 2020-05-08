package com.neeraj.UserNotesSpringBootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.UserNotesSpringBootApp.model.NotesCategory;

public interface NotesCategoryRepository extends JpaRepository<NotesCategory, Integer>{

}
