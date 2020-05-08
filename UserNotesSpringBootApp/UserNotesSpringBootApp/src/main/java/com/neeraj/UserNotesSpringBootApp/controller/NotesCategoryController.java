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
public class NotesCategoryController 
{

	@Autowired
	NotesCategoryDAO notesCategoryDAO;
	
	@Autowired
	NotesDAO notesDao;
	
	
	//get all Category List
	@GetMapping("/categories")
	public List<NotesCategory> getAll()
	{
		return notesCategoryDAO.getAllCategory();
	}
	
	
	// Add new Category
	@PostMapping("/categories/")
	public ResponseEntity saveCategory(@RequestBody NotesCategory notesCategory)
	{
		
		return new ResponseEntity(notesCategoryDAO.saveCategory(notesCategory),HttpStatus.OK);
	}
	
	
	//Edit Category
	@PutMapping("/categories/{id}")
	public ResponseEntity updateCategory(@PathVariable(value="id") int categoryId ,@RequestBody NotesCategory notesCategory)
	{
		NotesCategory notes=notesCategoryDAO.findCategory(categoryId);
		
		if(notes==null)
		{
			ResponseEntity.notFound().build();
		}
		
		notes.setCategoryName(notesCategory.getCategoryName());
		
		return new ResponseEntity(notesCategoryDAO.saveCategory(notes),HttpStatus.OK);
	}
	
	
	//Delete Category
	@DeleteMapping("/categories/{id}")
	public void deteleCategory(@PathVariable(value="id") int category_id)
	{
		List<Notes> note=notesDao.FindByCategoryID(category_id);
		notesDao.deleteByCategoryId(note);
		
		NotesCategory notesCategory=notesCategoryDAO.findCategory(category_id);
		notesCategoryDAO.deleteCategory(notesCategory);
		
		
		
	}
}
