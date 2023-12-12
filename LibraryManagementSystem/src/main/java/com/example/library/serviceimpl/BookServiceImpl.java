package com.example.library.serviceimpl;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entities.Book;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repositary.BookRepository;
import com.example.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	//@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book login(int id,int price,String name,String tittle, String available) {
		 Book s = bookRepository.findByTittle(tittle);
		 
		 if(s!=null) {
			 if(s.getName().equals(name)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }
	  
	}

	@Override
	public Book addBook(Book book) {
		return  bookRepository.save(book);
	}

	@Override
	public Book updateDb(String tittle,Book book) {
		
		
		Book s1 = bookRepository.findByTittle(tittle);
		
		if(s1!=null) {
			s1.setId(book.getId());   
			s1.setPrice(book.getPrice());
			s1.setName(book.getName());
			s1.setAvailable(book.getAvailable());
			
		return bookRepository.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	@Override
	public void deleteDb(String tittle) {
	
		
		Book s2 = bookRepository.findByTittle(tittle);
		
		if(s2!=null) {
			bookRepository.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}

	

	
	
}



	