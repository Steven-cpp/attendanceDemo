package com.example.demo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Mapper.IEmployeeMapper;
import com.example.demo.Service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	IEmployeeMapper iEmployeeMapper;

	@Override
	public void insertEmployee(int empNo, String compName, String name, String passwd,String email,String id_number,String department,int age, String sex) {
		// TODO Auto-generated method stub
		if( iEmployeeMapper.findEmpById(empNo)==null)
		 iEmployeeMapper.insertEmployee(empNo, compName, name, passwd,email, id_number,department,age,sex);
		else
			throw new RuntimeException("您已经注册过了");
	}

	@Override
	public List<UserDao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPosition(int empNo) {
		// TODO Auto-generated method stub
		return iEmployeeMapper.findposition(empNo);
	}

	@Override
	public UserDao findEmpById(int empNo) {
		// TODO Auto-generated method stub
		return iEmployeeMapper.findEmpById(empNo);
	}

	
	

 

	
}
