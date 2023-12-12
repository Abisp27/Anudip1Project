package com.example.library.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.library.entities.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	@Query(value =  "select * from Publisher where Name =?" , nativeQuery = true)
	Publisher findByName(String name);
}
