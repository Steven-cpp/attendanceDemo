package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Dao.Form;
import com.example.demo.Dao.UserDao;

import java.util.List;

@Mapper
public interface IEmployeeMapper {

    @Select("SELECT * FROM employee")
    public List<UserDao> findAll();

    @Insert("INSERT INTO employee(emp_no, position, name, password,email,idnumber,department,age,sex)" +
            " VALUES(#{empNo}, #{position}, #{name}, #{passwd},#{email},#{id_number},#{department},#{age},#{sex})")
    public void insertEmployee(int empNo, String position, String name, String passwd,
    		String email,String id_number,String department,int age, String sex);

    @Update("UPDATE employee SET position = #{newPosition}")
    public void updatePosition(String newPosition);
    @Select("SELECT position FROM employee WHERE emp_no = #{emp_no}")
    public String getPosition(int emp_no);   
    @Select("SELECT position FROM employee WHERE emp_no = #{emp_no}")
    public String findposition (int emp_no);

    @Update("UPDATE employee SET age = #{newAge}")
    public void updateAge(String newAge);
    @Select("SELECT age FROM employee WHERE emp_no = #{emp_no}")
    public String getAge(int emp_no);

    @Update("UPDATE employee SET sex = #{newSex}")
    public void updateSex(String newSex);
    @Select("SELECT sex FROM employee WHERE emp_no = #{emp_no}")
    public String getSex(int emp_no);

    @Update("UPDATE employee SET tel = #{newTel}")
    public void updateTel(String newTel);
    @Select("SELECT tel FROM employee WHERE emp_no = #{emp_no}")
    public String getTel(int emp_no);

    @Update("UPDATE employee SET password = #{newPasswd}")
    public void updatePasswd(String newPasswd);
    
    @Select("SELECT password FROM employee WHERE emp_no = #{emp_no}")
    public String getPassword(int emp_no);
    
    @Select("SELECT department FROM employee WHERE emp_no = #{emp_no}")
    public String finddepartment (int emp_no);
    
    @Select("SELECT Email FROM employee WHERE position = #{position} and department=#{department} ")
    public String findEmailByPositionAndDepartment(String position,String department);
    
    @Select("SELECT Email FROM employee WHERE position = #{position} ")
    public String findEmailByPosition(String position);
    
    @Select("SELECT * FROM employee WHERE emp_no = {emp_no} and password=#{password}")
    public UserDao getUser(int emp_no,String password);
    
    @Select("SELECT * FROM employee WHERE emp_no = #{userId}")
    public UserDao findEmpById(int userId);
    
    @Select("SELECT email FROM employee WHERE emp_no = #{emp_no}")
    public String getEmail(int emp_no);
    
    @Select("SELECT name FROM employee WHERE emp_no = #{emp_no}")
    public String getName(int emp_no);

}
