package com.neeraj.UserNotesSpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neeraj.UserNotesSpringBootApp.Service.NotesCategoryDAO;
import com.neeraj.UserNotesSpringBootApp.Service.NotesDAO;
import com.neeraj.UserNotesSpringBootApp.model.Notes;
import com.neeraj.UserNotesSpringBootApp.model.NotesCategory;

@RestController
@CrossOrigin(origins="*")
public class NotesController 
{

	@Autowired
	NotesDAO notesDao;
	
	@Autowired
	NotesCategoryDAO notesCategory;
	
	//get All Notes
	@GetMapping("/notes")
	public List<Notes> getAllNotes()
	{
		return notesDao.getAllNotes();
	}
	

	//Find by Category ID
	@GetMapping("/notes/{id}")
	public ResponseEntity findByCategoryId(@PathVariable(value="id") Integer categoryId)
	{
		List<Notes> note=notesDao.FindByCategoryID(categoryId);
		if(note==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity(note,HttpStatus.OK);
		
	}
	
	//save a new Note
	@PostMapping("/notes/{id}")
	public ResponseEntity saveNote(@PathVariable(value="id") int id ,@RequestBody Notes notes)
	{
		NotesCategory nc=notesCategory.findCategory(id);
		//System.out.println("*****************"+nc);
		NotesCategory nc1 = nc;
		//System.out.println("**********************"+nc1);
		Notes n=new Notes();
		n.setNotesCategory(nc1);
		n.setDiscription(notes.getDiscription());
		n.setName(notes.getName());
		n.setTitle(notes.getTitle());
		Notes note=notesDao.saveNote(n);
		
		if(n==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity(n,HttpStatus.OK);
	}
	
	
	//Edit the Note
	@PutMapping("/notes/{id}")
	public ResponseEntity editNote(@PathVariable(value="id") int notesId , @RequestBody Notes note)
	{
		Notes notes= notesDao.findNotes(notesId);
		System.out.println("***********"+notes);
		
		if(notes==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		System.out.println("****************"+note.getTitle());
		System.out.println("*************"+note.getName());
		notes.setTitle(note.getTitle());
		notes.setDiscription(note.getDiscription());
		notes.setName(note.getName());
		
		return new ResponseEntity(notesDao.saveNote(notes),HttpStatus.OK);
	}
	
	
	//Delete Note
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@PathVariable(value="id") int noteId)
	{
		Notes note=notesDao.findNotes(noteId);
		
		notesDao.deleteNote(note);
	}
}
