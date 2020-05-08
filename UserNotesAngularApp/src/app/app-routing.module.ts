import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotesCategoryService } from './Service/notes-category.service';
import { NotesCategoryComponent } from './Component/notes-category/notes-category.component';

import { NotesComponent } from './Component/notes/notes.component';


const routes: Routes = 
[
  {path: 'all', component:NotesCategoryComponent},
  {path: 'all/:id', component:NotesCategoryComponent},
  {path: 'category/:id', component:NotesCategoryComponent},
  {path: '', redirectTo: '/all', pathMatch: 'full'} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
