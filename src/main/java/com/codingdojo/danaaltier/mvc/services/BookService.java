package com.codingdojo.danaaltier.mvc.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.danaaltier.mvc.models.Book;
import com.codingdojo.danaaltier.mvc.repositories.BookRepository;


@Service
public class BookService {

	// adding the book repository as a dependency
	private final BookRepository bookRepository;
 
	
	public BookService(BookRepository bookRepository) {
	    this.bookRepository = bookRepository;
	}
	 
	 
	// returns all the books
	public List<Book> allBooks() {
	    return bookRepository.findAll();
	}
	
	
	// creates a book
	public Book createBook(Book b) {
	    return bookRepository.save(b);
	}
	
	
	// retrieves a book
	public Book findBook(Long id) {
	    Optional<Book> optionalBook = bookRepository.findById(id);
	    
	    if(optionalBook.isPresent()) {
	        return optionalBook.get();
	    } else {
	        return null;
	    }
	}
	
	
	public Book updateBook(Book b) {
		return updateBook(b.getId(), b.getTitle(), b.getDescription(), b.getLanguage(), b.getNumberOfPages());
	}
	
	// updates a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional <Book> temp = bookRepository.findById(id);
    	
    	if(temp != null) {
    		temp.get().setTitle(title);
    		temp.get().setDescription(desc);
    		temp.get().setLanguage(lang);
    		temp.get().setNumberOfPages(numOfPages);
    		return bookRepository.save(temp.get());
    	}
    	
    	return null;        
    }
    
	
    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}


