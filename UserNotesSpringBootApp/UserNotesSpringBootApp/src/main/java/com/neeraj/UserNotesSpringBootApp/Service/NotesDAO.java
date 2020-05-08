package com.neeraj.UserNotesSpringBootApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.UserNotesSpringBootApp.model.Notes;
import com.neeraj.UserNotesSpringBootApp.repository.NotesRepository;

@Service
public class NotesDAO 
{
	@Autowired
	NotesRepository notesrepository;
	
	//get All the Notes
	public List<Notes> getAllNotes()
	{
		return notesrepository.findAll();
	}
	
	
	//Save Note
	public Notes saveNote(Notes notes)
	{
		return notesrepository.save(notes);
	}


	//find note by ID
	public Notes findNotes(int id )
	{
		return notesrepository.findById(id).orElse(null);
		
	}
	
	//Find By Category ID
	public List<Notes> FindByCategoryID(Integer categoryId)
	{
		return notesrepository.findByCategoryID(categoryId);
	}
	
	//delete note
    public void deleteNote(Notes notes)
    {
    	notesrepository.delete(notes);
    }
	
// Delete By categoryId
    public void deleteByCategoryId(List<Notes> notes)
    {
    	notesrepository.deleteAll(notes);
    }

}
