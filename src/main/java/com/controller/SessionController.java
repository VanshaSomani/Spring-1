package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SessionController {
	@Autowired
	UserDao userDao;
	@PostMapping("/signup")
	public UserBean signup(@RequestBody UserBean userBean) {
		//TODO: process POST request
		userDao.addUser(userBean);
		return userBean;
	}
	
}
