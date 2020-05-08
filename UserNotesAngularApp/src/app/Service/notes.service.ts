import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Notes } from '../Models/notes';

@Injectable({
  providedIn: 'root'
})
export class NotesService {

  path:string="http://localhost:8080/notes";
  constructor(private _httpClient:HttpClient) { }

getAllNotes():Observable<Notes>
{
return this._httpClient.get<Notes>(this.path)
}


getNoteByCategoryId(categoryId:number):Observable<Notes>
{
  return this._httpClient.get<Notes>(this.path+"/"+categoryId)
}


//save 

saveNewNote(note:Notes,id:number)
{
  return this._httpClient.post(this.path+"/"+id,note);
}


//edit Note

editNote(note:Notes)
{
 return this._httpClient.put(this.path+"/"+note.notesId,note);
}

//delete Note

deleteNote(id:number)
{
 return this._httpClient.delete(this.path+"/"+id);
}

}



