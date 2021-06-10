package com.bareet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.bareet.models.Book;
import com.bareet.models.Store;
import com.bareet.repos.BookRepository;
import com.bareet.repos.StoreRepository;

@Service
public class BookService {

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	BookRepository bookRepository;

	public void addBook(Long id, Book book) throws Exception {
		Optional<Store> storeOpt = storeRepository.findById(id);
		if (!storeOpt.isPresent()) {
			throw new Exception("Store Id not found!");
		}
		Store store = storeOpt.get();
		store.getBooks().add(book);
		storeRepository.save(store);
	}

	public void updateBook(Long id,Book book) {
		book.setBookId(id);
		bookRepository.save(book);
	}

	public void removeBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

}
