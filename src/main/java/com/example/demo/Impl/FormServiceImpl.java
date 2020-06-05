package com.example.demo.Impl;

import java.util.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.Form;
import com.example.demo.Mapper.FormMapper;
import com.example.demo.Mapper.IEmployeeMapper;
import com.example.demo.Service.FormService;
import com.example.demo.Service.IMailService;
import com.example.demo.jwt.annot.AuthDM;
import com.example.demo.jwt.annot.AuthGM;
import com.example.demo.jwt.annot.AuthVM;

@Service
public class FormServiceImpl implements FormService{

	@Autowired
	private FormMapper formMapper;
	
	@Autowired
	private IMailService IMailService;
	
	@Autowired
	IEmployeeMapper iEmployeeMapper;
	
	@Override
	public void insertApply(int emp_no, Date sd, Date ed,String reason,String type) {
		// TODO Auto-generated method stub
		 java.sql.Date sd2 = new java.sql.Date(sd.getTime());
		 java.sql.Date ed2 = new java.sql.Date(ed.getTime());
		long diff = ed.getTime() - sd.getTime();//这样得到的差值是微秒级别
	    int days = (int) (diff / (1000 * 60 * 60 * 24));
	    String name= iEmployeeMapper.getName(emp_no);
	    formMapper.insertApply(emp_no, sd2, ed2, reason,days,type,name);
	    String deparment= iEmployeeMapper.finddepartment(emp_no);
	    System.out.println(deparment);
	    String position="DM";
	    notify(position,deparment,emp_no);   
	}
	
	public List<Form> ListByID(int empNo) {
		// TODO Auto-generated method stub
		String position= iEmployeeMapper.findposition(empNo);
		switch(position) {
		 case "DM":return findApplyByState(empNo,1); 
		 case "VM":return formMapper.findByState(2);
		 case "GM":return formMapper.findByState(3);
		 default: return formMapper.findByID(empNo);
		}
	}
	
	private void notify(String position,String department,int emp_no ) {
		String email= iEmployeeMapper.findEmailByPositionAndDepartment(position,department);
		String subject="有新的申请请查看";
		String name= iEmployeeMapper.getName(emp_no);
		String content="有来自"+name+"的请假申请请查看";
		if(email!=null)
		 {
			IMailService.sendSimpleMail(email, subject, content);
		 }
	}
	
	private void notify(String position,int aid ) {
		String email= iEmployeeMapper.findEmailByPosition(position);
		String subject="有新的申请请查看";
		String name= formMapper.getName(aid);
		String content="有来自"+name+"的请假申请请查看";
		if(email!=null)
		 {
			IMailService.sendSimpleMail(email, subject, content);
		 }
	}
	
	private void notify2(int aid ,String subject) {
		String email= iEmployeeMapper.getEmail(formMapper.getEmp_no(aid));
		String name= formMapper.getName(aid);
		String content="有来自"+name+"的请假申请请查看";
		if(email!=null)
		 {
			IMailService.sendSimpleMail(email, subject, content);
		 }
	}
	
	private void notify3(int aid ,String subject,String content) {
		String email= iEmployeeMapper.getEmail(formMapper.getEmp_no(aid));
		if(email!=null)
		 {
			IMailService.sendSimpleMail(email, subject, content);
		 }
	}
	
	
	public List<Form> findApplyByState(int emp_no,int state) {
		String deparment= iEmployeeMapper.finddepartment(emp_no);
		return formMapper.findApplyByState( state, deparment);
	}
	
	@Override
	public void updateState(int aid, int empNo, String reason, String decision) {
		// TODO Auto-generated method stub
		int state=formMapper.getState(aid);
		switch(state) {
		 case 0:throw new RuntimeException("已经被拒了或者已经取消了");
		 case 1:handle_DM(aid,empNo,reason,decision);break;
		 case 2:handle_VM(aid,empNo,reason,decision);break;
		 case 3:handle_GM(aid,empNo,reason,decision);break;
		 case 4:throw new RuntimeException("已经通过了");
		 default:throw new RuntimeException("出错");
		}
	}
	
	@AuthDM
	private void handle_DM(int aid, int empNo, String reason, String decision) {
		// TODO Auto-generated method stub
		String position= iEmployeeMapper.findposition(empNo);
		if(!position.equals("DM"))
		{
			throw new RuntimeException("您没有权限");
		}
		if(decision.equals("Yes"))
		{
			int days=formMapper.getDays(aid);
			formMapper.updateState(aid, 2);
			notify("VM",aid);
		}
		else 
		{
			updateState_Reject(aid,reason,empNo);
		}
		
	}
	
	@AuthVM
	private void handle_VM(int aid, int empNo, String reason, String decision) {
		// TODO Auto-generated method stub
		String position= iEmployeeMapper.findposition(empNo);
		if(!position.equals("VM"))
		{
			throw new RuntimeException("您没有权限");
		}
		if(decision.equals("Yes"))
		{
			int days=formMapper.getDays(aid);
			formMapper.updateState(aid, 3);
			if(days<3) {
				String subject="您的申请已经通过";
					System.out.println("已通过");
					notify2(aid,subject); 
			}
			else
			{
				notify("GM",empNo);
			}
		}
		else 
		{
			updateState_Reject(aid,reason,empNo);
		}
	}
	@AuthGM
	private void handle_GM(int aid, int empNo, String reason, String decision) {
		// TODO Auto-generated method stub
		String position= iEmployeeMapper.findposition(empNo);
		if(!position.equals("GM"))
		{
			throw new RuntimeException("您没有权限");
		}
		if(decision.equals("Yes"))
		{
			formMapper.updateState(aid, 4);
			String subject="您的申请已经通过";
			System.out.println("已通过");
			notify2(aid,subject); 
		}
		else 
		{
			updateState_Reject(aid,reason,empNo);
		}
	}


	private void updateState_Reject(int ad, String reason, int empNo) {
		// TODO Auto-generated method stub
		formMapper.updateState(ad, 0);
		String subject="您的申请号为"+ad+"的申请未通过";
		String context= iEmployeeMapper.getName(empNo)+"拒绝，因为"+reason;
		notify3(ad,subject,context);
		System.out.println("未通过");
	}
	@Override
	public List<Form> findByID(int emp_no) {
		// TODO Auto-generated method stub
		return formMapper.findByID(emp_no);
	}
	
	@Override
	public void delete(int ad) {
	       formMapper.deleteApply(ad);
	}

	@Override
	public List<Form> findByState(int state) {
		// TODO Auto-generated method stub
		return formMapper.findByState(state);
	}






}
