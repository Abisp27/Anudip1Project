package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.entities.Book;
@Service
public interface BookService { 
	Book login(int id,int price,String name,String tittle, String available );


	Book addBook(Book book);

	Book updateDb(String tittle,Book book);

	void deleteDb(String tittle);


	


	
}
