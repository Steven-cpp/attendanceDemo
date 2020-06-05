package com.example.demo.Dao;

import java.util.Date;

public class UserDao 
{
	  
		private String email;
		//身份证号
		private String idnumber;	
		private int emp_no;
	    private String department;
	    private String position;
	    private String name;
	    private int age;
	    private String sex;
	    private String tel;
	    private String password;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getIdnumber() {
			return idnumber;
		}
		public void setIdnumber(String idnumber) {
			this.idnumber = idnumber;
		}
		public int getEmp_no() {
			return emp_no;
		}
		public void setEmp_no(int emp_no) {
			this.emp_no = emp_no;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	    
}

