package com.bareet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bareet.models.Book;
import com.bareet.models.Store;
import com.bareet.models.User;
import com.bareet.services.BookService;
import com.bareet.services.StoreService;
import com.bareet.services.UserService;

@RestController
@RequestMapping("/app")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	StoreService storeService;
	 
	@Autowired
	BookService bookService;
		
	//For SignUp
	@PostMapping("/signup")
	public Long signUp(@RequestBody User user) {
			return userService.signUp(user);
	}
	
	//For LogIn
	@PostMapping("/signin")
	public String login(@RequestBody User user) {
			if(userService.login(user)==true)
				return "You have loggedIn successfully.......";
			else 
				return "Invalid Credentials";
	}
	
	//For List of all stores for the user
	@GetMapping("/{userId}/get-stores")
	public List<Store> getStores(@PathVariable("userId") Long id){
		return userService.getStores(id);
	}
	
	//For List out all the books in inventory inside the store.
	@GetMapping("/user/{storeId}/get-books")
	public Object getBooks(@PathVariable("storeId") Long storeId){
		return storeService.getBooks(storeId);
	}
	
	//For Add a new book.
	@PostMapping("/add-book/user/{storeId}")
	public void addBook(@PathVariable("storeId") Long storeId,@RequestBody Book book) throws Exception {
		bookService.addBook(storeId,book);
	}
	
	//For Update inventory for an existing book.
	@PutMapping("/user/store/{bookId}/update-book")
	public void updateBook(@PathVariable("bookId") Long bookId,@RequestBody Book book) {
		bookService.updateBook(bookId,book);
	}
	
	//For Remove a Book from the inventory
	@DeleteMapping("remove-book/{bookId}")
	public void removeBook(@PathVariable("bookId") Long bookId) {
		bookService.removeBook(bookId);
	}
}
