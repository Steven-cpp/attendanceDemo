package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.Form;
import com.example.demo.Service.FormService;
import com.example.demo.jwt.annot.AuthDM;
import com.example.demo.jwt.annot.UserLoginToken;

@Controller
@RequestMapping("/Form")
public class FormController {
	@Autowired
	FormService formService;
	
	/**
	 * 请假单
	 * @param emp_no 员工编号
	 * @param sd 起始日期
	 * @param reason 原因
	 * @param type 类型  外出/请假
	 * @param ed 终止日期
	 * @return
	 */
	@UserLoginToken
	@PostMapping("/add")
	@ResponseBody
	public String addForm(@RequestParam("empNo")int emp_no, @RequestParam("sd")Date sd,
			@RequestParam("reason")String reason, @RequestParam("ed")Date ed,
			@RequestParam("type")String type)
	{
		formService.insertApply(emp_no, sd, ed,reason,type);
		return "建表成功";
	}
	
	//全体员工都可查看成功请假表
	@UserLoginToken
	@GetMapping("/list")
	@ResponseBody
	public List<Form> list_Form()
	{
		return formService.findByState(4);
	}
	
	
	@GetMapping("/list/toWork/{id}")
	@ResponseBody
	@UserLoginToken
	public List<Form> list_Forms_todo(@PathVariable("id") int id) {
		return formService.ListByID(id);
	}
	
	
	//处理
	@PostMapping("/handle")
	@ResponseBody
	@UserLoginToken
	public String handleForm(@RequestParam("aid")int aid,@RequestParam("decision")String decision,
			@RequestParam("reason")String reason,@RequestParam("empNo") int empNo)
	{

		formService.updateState(aid,empNo,reason,decision);
		return "处理成功";
	}
	
	@DeleteMapping("/delete/{aid}")
	@ResponseBody
	@UserLoginToken
	public String delete(@PathVariable("aid")int aid) {
		formService.delete(aid);
		return "删除成功";
	}
	
	@ResponseBody
    @GetMapping("/list/{id}")
    @UserLoginToken
    public List<Form> get(@PathVariable("id") int id) {
        return formService.findByID(id);
    }
}
