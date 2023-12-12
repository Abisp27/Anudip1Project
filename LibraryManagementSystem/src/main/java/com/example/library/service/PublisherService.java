package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.entities.Publisher;
@Service
public interface PublisherService { 
	Publisher publisher(int id,String name, String address );


	Publisher addPublisher(Publisher publisher);

	Publisher updateDb(String name,Publisher publisher);

	void deleteDb(String name);


	


	
}
