package com.example.demo.Impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.AttendanceDao;
import com.example.demo.Mapper.ICheckInfoMapper;
import com.example.demo.Service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	 ICheckInfoMapper  iCheckInfoMapper;
	
	@Value("${spring.work_time}")
    private int work_time;
	
	@Override 
	public void create(int emp_no) {
		// TODO Auto-generated method stub
		java.util.Date d = new java.util.Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		Time time = new Time(d.getTime());
		if(d.getHours()<=work_time)
		 {
			iCheckInfoMapper.insertCheckDate(emp_no,date);
			iCheckInfoMapper.updateCheckIn(emp_no, date, time);
		 }
		else
		{
			throw new RuntimeException("你迟到了");
		}
	}
	
	@Override 
	public void add(int emp_no) {
		// TODO Auto-generated method stub
//		System.out.println("开始");
		java.util.Date d = new java.util.Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		Time time = new Time(d.getTime());
		System.out.println(iCheckInfoMapper.findByIdAndDate(emp_no, date));
		if(!iCheckInfoMapper.findByIdAndDate(emp_no, date).isEmpty())
		{
//			System.out.println("开始2");
			iCheckInfoMapper.updateCheckOut(emp_no,date,time);
		}
		else {
//			System.out.print("签退成功");
			iCheckInfoMapper.insertCheckDate(emp_no,date);
			iCheckInfoMapper.updateCheckOut(emp_no,date,time);
		}
	}
	

	@Override
	public List<AttendanceDao> findAll() {
		// TODO Auto-generated method stub
		return  iCheckInfoMapper.findAll();
	}

	@Override
	public List<AttendanceDao> findBydate(Date date) {
		// TODO Auto-generated method stub
		java.sql.Date dt = new java.sql.Date(date.getTime());
		return iCheckInfoMapper.findByDate(dt) ;
	}

	@Override
	public List<AttendanceDao> findByID(int id) {
		// TODO Auto-generated method stub
		return iCheckInfoMapper.findByID(id);
	}

	@Override
	public List<AttendanceDao> findByIdAndDate(int id, Date date) {
		// TODO Auto-generated method stub
		java.sql.Date dt = new java.sql.Date(date.getTime());
		return iCheckInfoMapper.findByIdAndDate(id, dt);
	}


}
