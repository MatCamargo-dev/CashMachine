package com.h2.db.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h2.db.model.User;

@Repository
public interface UserRepository
		extends CrudRepository<User, Long> {

}
