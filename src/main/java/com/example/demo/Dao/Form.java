package com.example.demo.Dao;
import java.sql.Date;
import java.sql.Time;

public class Form {
	   private int aid;
	    private int emp_no;
	    private Date start_date;
	    private Date end_date;
	    private int days;
	    // "apply_date" will update automatically
//	    private java.util.Date apply_time;
	    private String reason;
	    private int state;
	    private String type;
	    private String name;

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getAid() {
			return aid;
		}

		public void setAid(int aid) {
			this.aid = aid;
		}

		public int getEmp_no() {
	        return emp_no;
	    }

	    public void setEmp_no(int emp_no) {
	        this.emp_no = emp_no;
	    }

	    public Date getStart_date() {
	        return start_date;
	    }

	    public void setStart_date(Date start_date) {
	        this.start_date = start_date;
	    }

	    public Date getEnd_date() {
	        return end_date;
	    }

	    public void setEnd_date(Date end_date) {
	        this.end_date = end_date;
	    }

	    public int getDays() {
			return days;
		}

		public void setDays(int days) {
			this.days = days;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

//		public java.util.Date getApply_time() {
//	        return apply_time;
//	    }
//
//	    public void setApply_time(java.util.Date apply_time) {
//	        this.apply_time = apply_time;
//	    }


	    public int state() {
	        return state;
	    }

	    public void setApply_sate3(int  state) {
	        this. state =  state;
	    }
}
