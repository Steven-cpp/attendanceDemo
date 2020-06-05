package com.example.demo.Dao;

import java.sql.Time;
import java.sql.Date;

public class AttendanceDao {
	   private int emp_no;
	    private Date date;
	    private Time cardIn_time;
	    private Time cardOut_time;

	    public int getEmp_no() {
	        return emp_no;
	    }

	    public void setEmp_no(int emp_no) {
	        this.emp_no = emp_no;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public Time getCardIn_time() {
	        return cardIn_time;
	    }

	    public void setCardIn_time(Time cardIn_time) {
	        this.cardIn_time = cardIn_time;
	    }

	    public Time getCardOut_time() {
	        return cardOut_time;
	    }

	    public void setCardOut_time(Time cardOut_time) {
	        this.cardOut_time = cardOut_time;
	    }
}
