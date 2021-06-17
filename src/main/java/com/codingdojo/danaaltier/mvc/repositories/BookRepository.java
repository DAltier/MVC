package com.codingdojo.danaaltier.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.danaaltier.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	 // this method retrieves all the books from the database
	 List<Book> findAll();
	 
	 
	 // this method finds books with descriptions containing the search string
	 List<Book> findByDescriptionContaining(String search);
	 
	 
	 // this method finds a book by the ID provided. returns null if not found
	 Optional<Book> findById(Long id);
		
	 
	 // this method deletes the book with the ID provided, if it exists
	 void deleteById(Long id);
}

