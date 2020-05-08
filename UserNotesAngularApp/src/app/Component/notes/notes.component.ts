import { Component, OnInit } from '@angular/core';
import { Notes } from 'src/app/Models/notes';
import { NotesService } from 'src/app/Service/notes.service';

import { ActivatedRoute, Router } from '@angular/router';
import { Variable } from '@angular/compiler/src/render3/r3_ast';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {

 public notes:Notes;
 
  constructor(private _notesServie:NotesService, private  _activatedRoute:ActivatedRoute ,private _router:Router) { }

  ngOnInit(): void 
  {
    this._activatedRoute.paramMap.subscribe(()=>{this.getNotes()});
  }

  searchBook:boolean;
  getNotes()
  {

    this.searchBook=this._activatedRoute.snapshot.paramMap.has('keyword');
   
    if(this.searchBook)
    {
      this.getSearchNote();
    }
    else
    {
      this.getAllNotes();
    }


  }

  getSearchNote()
  {
  }

categoryId:number;
id1:number;

newButton:boolean=false;
getAllNotes()
{

  this.categoryId=+this._activatedRoute.snapshot.paramMap.get('id');

  if(this.categoryId>0)
  {
    this.newButton=true;
    this.id1=+this._activatedRoute.snapshot.paramMap.get('id');
    this._notesServie.getNoteByCategoryId(this.id1).subscribe(data=>this.notes=data);
  }
  else
  {
    this._notesServie.getAllNotes().subscribe(data=>this.notes=data);
     this.newButton=false;
  }
  
}



//Save New Note

divVisible:boolean=false;
DivVisible()
{
this.divVisible=true;
}

saveNewNote()
{
  this.divVisible=true;
} 

title:string;
name:string;
discription:string;
NewNote=new Notes;
catid:number;
SaveNewNote()
{

this.NewNote.title=this.title;
this.NewNote.discription=this.discription;
this.NewNote.name=this.name;
this.catid=+this._activatedRoute.snapshot.paramMap.get('id');
if(this.catid>0)
{
  this._notesServie.saveNewNote(this.NewNote,this.catid).subscribe();
  this._router.navigate(['/all']);
}
else
{
  this._notesServie.saveNewNote(this.NewNote,1).subscribe();
  this._router.navigate(['/all']);
}
}


//Edit Note

EditDivVisible=false;
notesId:number;
editNote(id:number)
{

this.notesId=id;
this.EditDivVisible=true;


}

cancleDiv()
{
  this.EditDivVisible=false;
   this.divVisible=false;
}

idForDelete:number;
deleteNote()
{
this.idForDelete=this.notesId;

console.log("idForDelete"+this.idForDelete);
this._notesServie.deleteNote(this.idForDelete).subscribe();
this.EditDivVisible=false;

this._router.navigate(['/all']);

}

NewEditableNote=new Notes;

SaveEditNote()
{

 
  this.NewEditableNote.notesId=this.notesId;
this.NewEditableNote.title=this.title;

this.NewEditableNote.discription=this.discription;

this.NewEditableNote.name=this.name;

this._notesServie.editNote(this.NewEditableNote).subscribe();

this.EditDivVisible=false;

this._router.navigate(['/all']);
}


}
