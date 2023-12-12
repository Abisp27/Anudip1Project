package com.example.library.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.example.library.entities.Publisher;
import com.example.library.service.PublisherService;




@RestController
public class PublisherController {

	//@Autowired
	PublisherService publisherService;

	@GetMapping("/publisher")
	public Publisher publisher(@RequestHeader int id,@RequestHeader String name ,@RequestHeader String address) {

		return publisherService.publisher(id,name,address); 
	}

	@PostMapping("/postpublisher")
	public Publisher addPublisher(@RequestBody Publisher publisher) {

		return publisherService.addPublisher(publisher);
	}

	@PutMapping("/nameupdate")
	public Publisher update(@RequestHeader int id,@RequestHeader String name,@RequestHeader String address , @RequestBody Publisher publisher ) {
		
		return publisherService.updateDb(name,publisher);
	}
	@DeleteMapping("/namedelete")
	public String delete(@RequestHeader String name) {
		publisherService.deleteDb(name);
		return "data deleted";
	}
	
	

}