package com.bareet.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bareet.models.Store;
import com.bareet.models.User;
import com.bareet.repos.UserRepository;
import com.bareet.utils.Sha256Util;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Long signUp(User user) {
		try {
			// Encrypting password
			user.setUserPassword(Sha256Util.encrypt(user.getUserPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		userRepository.save(user);
		return user.getUserId();
	}

	public boolean login(User user) {
		try {
//			Encrypting password
			user.setUserPassword(Sha256Util.encrypt(user.getUserPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Optional<User> tempUser = userRepository.findById(user.getUserId());
		if (tempUser.isPresent()) {
			if (user.getUserPassword().equals(tempUser.get().getUserPassword())) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public List<Store> getStores(Long id) {
		return userRepository.findById(id).get().getStores();
	}

}
