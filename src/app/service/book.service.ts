import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../entity/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8086/post';
  }
  findAll(): Observable<any> {
    console.log(Book)
    return this.http.get('http://localhost:8086/book');
  }

  public save(book: Book) {
    return this.http.post<Book>(this.usersUrl, book);
  }}
