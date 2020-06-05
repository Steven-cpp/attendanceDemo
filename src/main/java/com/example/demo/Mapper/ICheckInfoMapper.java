package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Dao.AttendanceDao;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ICheckInfoMapper {
	
		@Select("SELECT * FROM cardinfo")
	    public List <AttendanceDao> findAll();
		
		@Select("SELECT * FROM cardinfo WHERE emp_no = #{emp_no} ")
	    public List<AttendanceDao> findByID(int emp_no);

		@Select("SELECT * FROM cardinfo WHERE date = #{date} ")
	    public List<AttendanceDao> findByDate(Date date);
		
		@Select("SELECT * FROM cardinfo WHERE date = #{date} AND emp_no = #{emp_no}")
	    public List<AttendanceDao> findByIdAndDate(int emp_no, Date date);
		@Insert("INSERT INTO cardInfo(emp_no, date) VALUES (#{emp_no}, #{req_date})")
	    public void insertCheckDate (int emp_no, Date req_date);

	    @Update("UPDATE cardInfo SET cardIn_time = #{cardIn_time} " +
	            "WHERE emp_no = #{emp_no} AND date = #{req_date}")
	    public void updateCheckIn (int emp_no, Date req_date, Time cardIn_time);

	    @Update("UPDATE cardinfo SET cardOut_time = #{cardOut_time} " +
	            "WHERE emp_no = #{emp_no} AND date = #{req_date}")
	    public void updateCheckOut (int emp_no, Date req_date, Time cardOut_time);


}
