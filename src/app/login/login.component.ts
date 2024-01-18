import { Component } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  book:Book=new Book();


  constructor(private bookService:BookService){

  }

  ngOnInit():void{

  }
  Login(){
    console.log(this.book)
    this.bookService.save(this.book).subscribe((_data: any)=>{
      alert("Login Sucessfully")
      
    }
    )
  }
}
