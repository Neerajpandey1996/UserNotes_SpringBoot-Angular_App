package com.neeraj.UserNotesSpringBootApp.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.neeraj.UserNotesSpringBootApp.Exception.CategoryIdNotFoundException;
import com.neeraj.UserNotesSpringBootApp.Exception.NotesIdNotFoundException;
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
	public List<Notes> getAllNotes() throws Exception
	{
		try
		{
		return notesDao.getAllNotes();
		}
		catch(Exception e)
		{
			throw new Exception();
		}
		}
		
	

	//Find by Category ID
	@GetMapping("/notes/{id}")
	public ResponseEntity<List<Notes>> findByCategoryId(@Valid @PathVariable(value="id") int categoryId) throws CategoryIdNotFoundException
	{
		List<Notes> note=notesDao.FindByCategoryID(categoryId);
		if(note.isEmpty())
		{
			//System.out.println("Note is null");
			throw new CategoryIdNotFoundException("CategoryId "+categoryId+" not found");
		}
		
		return new ResponseEntity<List<Notes>>(note,HttpStatus.OK);
		
	}
	
	//save a new Note
	@PostMapping("/notes/{id}")
	public ResponseEntity<Notes> saveNote(@Valid @PathVariable(value="id") int id , @Valid @RequestBody Notes notes) throws CategoryIdNotFoundException
	{
		NotesCategory nc=notesCategory.findCategory(id);
		
		if(nc==null)
		{
				throw new CategoryIdNotFoundException("CategoryId "+id+" not found");
		}
		
		
		//System.out.println("*****************"+nc);
		NotesCategory nc1 = nc;
		//System.out.println("**********************"+nc1);
		Notes n=new Notes();
		
		n.setNotesCategory(nc1);
		n.setDiscription(notes.getDiscription());
		n.setName(notes.getName());
		n.setTitle(notes.getTitle());
		Notes note=notesDao.saveNote(n);
		
		
		return new ResponseEntity<Notes>(note,HttpStatus.OK);
	}
	
	
	//Edit the Note
	@PutMapping("/notes/{id}")
	public ResponseEntity<Notes> editNote(@Valid @PathVariable(value="id") int notesId , @Valid @RequestBody Notes note) throws NotesIdNotFoundException
	{
		Notes notes= notesDao.findNotes(notesId);
		//System.out.println("***********"+notes);
		
		if(notes==null)
		{
			throw new NotesIdNotFoundException("Notes ID "+notesId+" Not Found");
		}
		
		//System.out.println("****************"+note.getTitle());
		//System.out.println("*************"+note.getName());
		notes.setTitle(note.getTitle());
		notes.setDiscription(note.getDiscription());
		notes.setName(note.getName());
		
		return new ResponseEntity<Notes>(notesDao.saveNote(notes),HttpStatus.OK);
	}
	
	
	//Delete Note
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@Valid @PathVariable(value="id") int noteId) throws NotesIdNotFoundException
	{
		Notes note=notesDao.findNotes(noteId);
		if(note==null)
		{
			throw new NotesIdNotFoundException("Notes ID "+noteId+" Not Found");
		}
		notesDao.deleteNote(note);
	}
}
