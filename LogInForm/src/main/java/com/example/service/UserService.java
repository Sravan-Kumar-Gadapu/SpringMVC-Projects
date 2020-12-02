package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;
	public int create(User user) {
		return userdao.save(user);
	}
	
	public User validation(User user) {
		return userdao.validateForm(user.getEmail(), user.getPassword());
	}
}
