package com.MyPersonalTrainer.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MyPersonalTrainer.domain.User;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
}
