package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;
	public void addUser(UserBean user) {
		stmt.update("insert into users2 (firstName,email,password) values (?,?,?)", user.getFirstName(), user.getEmail(),user.getPassword());
	}

}
