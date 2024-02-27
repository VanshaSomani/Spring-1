package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/get")
	public List<UserBean> getAllUsers() {
		List<UserBean> users = userDao.getAllUsers();
		return users;
	}
	
	@GetMapping("/{userId}")
	public UserBean getUserById(@PathVariable("userId") Integer userId) {
		UserBean user = userDao.getUserById(userId);
		return user;
	}

	@DeleteMapping("/{userId}")
	public UserBean deleteUserById(@PathVariable("userId") Integer userId) {
		UserBean user = userDao.getUserById(userId);
		userDao.deleteUserById(userId);
		return user;
	}

	@PutMapping("/update")
	public UserBean updateUser(@RequestBody UserBean user) {
		userDao.updateUser(user);
		UserBean updatedUser = userDao.getUserById(user.getUserId());
		return updatedUser; 
	}
}
