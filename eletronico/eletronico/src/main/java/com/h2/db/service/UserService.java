package com.h2.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.db.exception.RecordNotFoundException;
import com.h2.db.model.User;
import com.h2.db.model.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> getAllUsers() {
		System.out.println("getAllUsers");
		List<User> result = (List<User>) repository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<User>();
		}
	}

	public User getUserById(Long id) throws RecordNotFoundException {
		System.out.println("getUserById");
		Optional<User> user = repository.findById(id);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RecordNotFoundException("No user record exist for given id");
		}
	}

	public User createOrUpdateUser(User entity) {
		System.out.println("createOrUpdateUser");
		// Create new entry
		if (entity.getId() == null) {
			entity = repository.save(entity);

			return entity;
		} else {
			// update existing entry
			Optional<User> user = repository.findById(entity.getId());

			if (user.isPresent()) {
				User newEntity = user.get();
				newEntity.setName(entity.getName());
				newEntity.setBalance(entity.getBalance());

				newEntity = repository.save(newEntity);

				return newEntity;
			} else {
				entity = repository.save(entity);

				return entity;
			}
		}
	}

	public void deleteUserById(Long id) throws RecordNotFoundException {
		System.out.println("deleteUserById");

		Optional<User> user = repository.findById(id);

		if (user.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No user record exist for given id");
		}
	}
}