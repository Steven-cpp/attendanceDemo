package com.example.demo.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.AttendanceDao;
import com.example.demo.Dao.Form;
import com.example.demo.Dao.UserDao;


public interface UserService {
	
	 List<UserDao> findAll();

	void insertEmployee(int empNo, String compName, String name, String passwd, String email, 
			String id_number,String department,int age, String sex);
	
	String findPosition(int empNo );
	
	public UserDao findEmpById(int empNo);

}

