import { Component, OnInit } from '@angular/core';
import { NotesCategory } from 'src/app/Models/notes-category';
import { NotesCategoryService } from 'src/app/Service/notes-category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notes-category',
  templateUrl: './notes-category.component.html',
  styleUrls: ['./notes-category.component.css']
})
export class NotesCategoryComponent implements OnInit {

  indexForAll:number=0;
  public notesCategory:NotesCategory;
 
  editValue:number=0;
  visible:boolean=false;
  newName:string="NewName";

  
  constructor(private _notesCategoryService:NotesCategoryService ,private router:Router ) 
  {
  
  }

  ngOnInit(): void 
  {
   this.getAllCategories();
   
  }

                              // Edit Category //

  editFun(value:number)
  {
    this.editValue=value;
    console.log(this.editValue);
    this.visible=true;
    
  }

  editCategory=new NotesCategory;
  erroMessage:string;
  saveNewCategoryName()
  {
    
    this.editCategory.categoryId=this.editValue;
    this.editCategory.categoryName=this.newName;
    this._notesCategoryService.editCategoryName(this.editCategory).subscribe();
    this.visible=false;
    this.newName="NewName";
    this.router.navigate(['/category']);
    location.reload();
  }
  
  cancelCategoryName()
  {
    this.visible=false;
  }


                              // Edit Category closed //


                              //Delete category//

    deletecategory(categoryId:number)
    {
       this._notesCategoryService.deleteCategoryName(categoryId).subscribe();
       location.reload();
    }
                              // Delete Category closed//


                              //Add New Category


    newCategory:string="NewName1";                          
    Namevisible:boolean=false;
    newCategoryName()
    {
        this.Namevisible=true;
    }

    NewCategory=new NotesCategory;
    addNewCategory()
    {
      this.NewCategory.categoryName=this.newCategory;
      this._notesCategoryService.newCategory(this.NewCategory).subscribe();
      this.Namevisible=false;
      this.newCategory="NewName1"
      location.reload();
      
    }

    cancelNewCategory()
    {
      this.Namevisible=false;
    }

                              // Add New Category Closed


 


  public getAllCategories()
  {
  
this._notesCategoryService.getAllCategory().subscribe(data=>this.notesCategory=data)
  }
}
