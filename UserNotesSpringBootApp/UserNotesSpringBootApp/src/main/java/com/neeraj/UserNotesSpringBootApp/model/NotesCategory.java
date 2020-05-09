package com.neeraj.UserNotesSpringBootApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="NotesCategory")
public class NotesCategory 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int categoryId;
	
	@NotEmpty(message="Category Name Can not be Empty")
	private String categoryName;

	
//	  @OneToMany(cascade=CascadeType.ALL) 
//	  private List<Notes> notes; 
//	  public List<Notes> getNotes() 
//	  {  return notes; 
//	  }
//	  public void setNotes(List<Notes> notes)
//	  {  this.notes = notes; 
//	  }
//	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

	@Override
	public String toString() {
		return "NotesCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", notes=" +"]";
	}
	
	
}
