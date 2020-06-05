package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import com.example.demo.Dao.AttendanceDao;

public interface AttendanceService {
	void add(int ID);
	
	List<AttendanceDao> findAll();
	
	void create(int emp_no);
	
	List<AttendanceDao> findBydate(Date date);

	List<AttendanceDao> findByID(int id);

	List<AttendanceDao> findByIdAndDate(int id, Date date);
}
