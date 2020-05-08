package com.neeraj.UserNotesSpringBootApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.UserNotesSpringBootApp.model.NotesCategory;
import com.neeraj.UserNotesSpringBootApp.repository.NotesCategoryRepository;

@Service
public class NotesCategoryDAO 
{
	
	@Autowired
	NotesCategoryRepository notescategoryrepository;
	
	//Add Category
	public NotesCategory saveCategory(NotesCategory category)
	{
		return notescategoryrepository.save(category);
	}
	
	
	//Show all Category
	public List<NotesCategory> getAllCategory()
	{
		
		return notescategoryrepository.findAll();
	}
	
	
	//Edit NotesCategory (name of the category) 
    public NotesCategory findCategory(int id)
    {
    	return notescategoryrepository.findById(id).orElse(null);
    }
	
    
    //Delete NotesCategory (delete define category)
    public void deleteCategory(NotesCategory notesCategory)
    {
    	notescategoryrepository.delete(notesCategory);
    }
}
