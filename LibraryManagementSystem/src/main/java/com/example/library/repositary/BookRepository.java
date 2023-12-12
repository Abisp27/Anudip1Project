package com.example.library.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value =  "select * from Book where Tittle =?" , nativeQuery = true)
	Book findByTittle(String tittle);
}

	
	