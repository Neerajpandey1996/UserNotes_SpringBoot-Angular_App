package com.neeraj.UserNotesSpringBootApp.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="NotesCategory")
public class NotesCategory 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	
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
