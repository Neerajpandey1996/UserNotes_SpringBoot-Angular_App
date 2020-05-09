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
	public List<NotesCategory> getAll() throws Exception
	{
		try
		{
		return notesCategoryDAO.getAllCategory();
		}
		catch(Exception e)
		{
			throw new Exception();
		}
		
		}
	
	
	// Add new Category
	@PostMapping("/categories/")
	public ResponseEntity<NotesCategory> saveCategory(@Valid @RequestBody NotesCategory notesCategory)
	{
		NotesCategory nCategory=notesCategoryDAO.saveCategory(notesCategory);
		
		return new ResponseEntity<NotesCategory>(nCategory,HttpStatus.OK);
	}
	
	
	//Edit Category
	@PutMapping("/categories/{id}")
	public ResponseEntity<NotesCategory> updateCategory(@Valid @PathVariable(value="id") int categoryId ,@Valid @RequestBody NotesCategory notesCategory) throws CategoryIdNotFoundException
	{
		NotesCategory notes=notesCategoryDAO.findCategory(categoryId);
		
		if(notes==null)
		{
			throw new CategoryIdNotFoundException("Category Id :"+categoryId+" Not Found");
		}
		
		notes.setCategoryName(notesCategory.getCategoryName());
		
		return new ResponseEntity<NotesCategory>(notesCategoryDAO.saveCategory(notes),HttpStatus.OK);
	}
	
	
	//Delete Category
	@DeleteMapping("/categories/{id}")
	public void deteleCategory(@Valid @PathVariable(value="id") int category_id) throws CategoryIdNotFoundException
	{
	
       NotesCategory notesCategory=notesCategoryDAO.findCategory(category_id);
		
		if(notesCategory==null)
		{
			throw new CategoryIdNotFoundException("Category Id :"+category_id+" Not Found");
		}
		
		
		//find all the Note which belongs to this particular CategoryID 
		List<Notes> note=notesDao.FindByCategoryID(category_id);
		notesDao.deleteByCategoryId(note);
		
		//delete Category
		notesCategoryDAO.deleteCategory(notesCategory);
			
	}
}
