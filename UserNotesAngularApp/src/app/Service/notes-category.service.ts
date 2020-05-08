import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map,catchError } from 'rxjs/operators';

import { Observable } from 'rxjs';
import { NotesCategory } from '../Models/notes-category';

@Injectable({
  providedIn: 'root'
})
export class NotesCategoryService {

  path:string="http://localhost:8080/categories/";
  constructor(private httpClient : HttpClient) { }

  public getAllCategory():Observable<NotesCategory>
  {
    return this.httpClient.get<NotesCategory>(this.path);
  }


  //Edit 
  public editCategoryName(notesdetails:NotesCategory)
  {
    
    return this.httpClient.put(`${this.path}/${notesdetails.categoryId}`,notesdetails,{headers:new HttpHeaders({
     })
    });
  }


  //Delete
 public deleteCategoryName(id:number)
  {
    return this.httpClient.delete(`${this.path}/${id}`);
  }


  //Post

 public newCategory(name:NotesCategory)
  {
   return this.httpClient.post(this.path,name);
  }

}
