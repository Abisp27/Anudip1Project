package com.example.library.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entities.Book;
import com.example.library.service.BookService;



@RestController
public class BookController {

	//@Autowired
	BookService bookService;

	@GetMapping("/login")
	public Book login(@RequestHeader int id,@RequestHeader int price,@RequestHeader String name ,@RequestHeader String tittle,@RequestHeader String available) {

		return bookService.login(id, price,name,tittle,available); 
	}

	@PostMapping("/post")
	public Book addBook(@RequestBody Book book) {

		return bookService.addBook(book);
	}

	@PutMapping("/update")
	public Book update(@RequestHeader int id,@RequestHeader int price,@RequestHeader String name,@RequestHeader String tittle,@RequestHeader String available , @RequestBody Book book ) {
		
		return bookService.updateDb(tittle,book);
	}
	@DeleteMapping("/delete")
	public String delete(@RequestHeader String tittle) {
		bookService.deleteDb(tittle);
		return "data deleted";
	}
	
	

}