package com.example.library.serviceimpl;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.entities.Publisher;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repositary.PublisherRepository;
import com.example.library.service.PublisherService;


@Service
public class PublisherServiceImpl implements PublisherService {

	//@Autowired
	PublisherRepository publisherRepository;
	
	@Override
	public Publisher publisher(int id,String name, String address) {
		 Publisher s = publisherRepository.findByName(name);
		 
		 if(s!=null) {
			 if(s.getAddress().equals(address)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }
	  
	}

	@Override
	public Publisher addPublisher(Publisher publisher) {
		return  publisherRepository.save(publisher);
	}

	@Override
	public Publisher updateDb(String name,Publisher publisher) {
		
		
		Publisher s1 = publisherRepository.findByName(name);
		
		if(s1!=null) {
			s1.setId(publisher.getId());   
			s1.setAddress(publisher.getAddress());
			
		return publisherRepository.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	@Override
	public void deleteDb(String name) {
	
		
		Publisher s2 = publisherRepository.findByName(name);
		
		if(s2!=null) {
			publisherRepository.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}

	

	
	
}



	