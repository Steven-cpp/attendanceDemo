package com.example.demo.Mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Dao.Form;
import com.example.demo.Dao.UserDao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Mapper
public interface FormMapper {
		@Insert("INSERT INTO outapply(emp_no, start_date, end_date, reason, days, type,name,state) " +
	            "VALUES ( #{emp_no}, #{sd}, #{ed}, #{reason},#{days},#{type},#{name},1)")
	    public void insertApply(int emp_no, Date sd, Date ed,String reason,int days,String type,String name );

	    @Update("UPDATE outapply SET days = #{len} WHERE aid = #{aid}")
	    public void updateLen(int aid, int len);

	    @Update("UPDATE outapply SET reason = #{reason} WHERE aid = #{aid}")
	    public void updateReason(int aid, String reason);

	    @Update("UPDATE outapply SET state = #{state} WHERE aid = #{aid}")
	    public void updateState(int aid, int state);
	

	    @Delete("DELETE FROM outapply WHERE aid = #{aid}")
	    public void deleteApply(int aid);
	    
	    @Select("SELECT * FROM outapply where emp_no = #{emp_no}")
	    public List<Form> findByID(int emp_no);
	    
	    @Select("SELECT * FROM outapply where state = #{state}")
	    public List<Form> findByState(int state);
	    
	    @Select("SELECT state FROM outapply where aid = #{aid}")
	    public int getState(int aid);
	    
	    @Select("SELECT days FROM outapply where aid = #{aid}")
	    public int getDays(int aid);
	    
	    @Select("SELECT emp_no FROM outapply where aid = #{aid}")
	    public int getEmp_no(int aid);

	    @Select("SELECT name FROM outapply where aid = #{aid}")
	    public String getName(int aid);
	    
	    @Select("SELECT * FROM outapply WHERE state = #{state} AND emp_no " 
	    		+"in ( SELECT emp_no FROM employee WHERE department = #{department});")
	    public List<Form> findApplyByState(int state,String department );
}
