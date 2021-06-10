package com.bareet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bareet.models.Book;
import com.bareet.models.Store;
import com.bareet.repos.StoreRepository;
import com.bareet.repos.UserRepository;

@Service
public class StoreService {
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Book> getBooks(Long id){
		return storeRepository.getById(id).getBooks();
	}
	
	public Object getStores(Long storeId){
		Optional<Store> tempStore=storeRepository.findById(storeId);
		if(tempStore.isPresent()) {
			return storeRepository.findById(storeId).get().getBooks();
		}
		else
			return false;
	}
		
}
