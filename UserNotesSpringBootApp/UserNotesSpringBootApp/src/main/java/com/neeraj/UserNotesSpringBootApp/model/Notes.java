package com.neeraj.UserNotesSpringBootApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Notes")
public class Notes 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int notesId;
	
	private String title;
	
	private String discription;
	
	private String name;

//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="category_id" )

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private NotesCategory notesCategory;
	
	public NotesCategory getNotesCategory() {
		return notesCategory;
	}

	public void setNotesCategory(NotesCategory notesCategory) {
		this.notesCategory = notesCategory;
	}

	public int getNotesId() {
		return notesId;
	}

	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "Notes [notesId=" + notesId + ", title=" + title + ", discription=" + discription + ", name=" + name
				+ ", notesCategory=" + notesCategory + "]";
	}

	
	
	
	
	
}
