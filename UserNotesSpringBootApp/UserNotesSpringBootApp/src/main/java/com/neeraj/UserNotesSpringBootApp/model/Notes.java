package com.neeraj.UserNotesSpringBootApp.model;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Notes")
public class Notes 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int notesId;
	
	@NotEmpty(message="Title Can not be Empty" )
	private String title;
	
	@NotEmpty(message="Discription Can not be Empty")
	private String discription;
	
	@NotEmpty(message="Name can Not be Empty")
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
