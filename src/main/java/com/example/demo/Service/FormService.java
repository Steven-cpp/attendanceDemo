package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import com.example.demo.Dao.Form;

public interface FormService {
	public void insertApply (int emp_no, Date sd, Date ed,String reason,String type);
	
	List<Form> ListByID(int emp_no);
	
	List<Form> findByID(int emp_no);
	
	List<Form> findByState(int state);
	
	public void delete(int ad);

	public void updateState(int aid, int empNo, String reason, String decision);
	
}
