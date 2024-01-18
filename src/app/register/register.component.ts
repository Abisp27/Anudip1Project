import { Component } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  book:Book=new Book();


  constructor(private bookService:BookService){

  }

  ngOnInit():void{

  }
  Login(){
    console.log(this.book)
    this.bookService.save(this.book).subscribe((_data: any)=>{
      alert("Login Sucessfully")
      
    },()=>alert("Sorry please enter crrect Email and Password")
    )
  }
}


