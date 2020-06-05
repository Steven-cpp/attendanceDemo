package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.AttendanceDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.Service.AttendanceService;
import com.example.demo.jwt.annot.UserLoginToken;


@Controller
public class AttendanceController {
	
	@Autowired
	AttendanceService  attendanceService;
	
	/**
	 * 打卡
	 * @param id 员工号
	 * @return
	 */
	@UserLoginToken
	@PostMapping("/checkin")
	@ResponseBody
	public String checkin( @RequestParam("id")int id) {
	 attendanceService.create(id);
		System.out.print(id);
		return "签到成功";
	}
	
	/**
	 * 下班
	 * @param id 员工号
	 * @return
	 */
	@UserLoginToken
	@PostMapping("/checkout")
	@ResponseBody
	public String checkout( @RequestParam("id")int id) {
	 attendanceService.add(id);
		System.out.print(id);
		return "签退成功";
	}
	
	@UserLoginToken
	@GetMapping("/listAttendance")
	@ResponseBody
	public List<AttendanceDao>  find() {
		return attendanceService.findAll();
	}
	
	@UserLoginToken
	@GetMapping("/listAttendanceDate/{date}")
	@ResponseBody
	public List<AttendanceDao>  findBydate(@PathVariable("date") Date date) {
		return attendanceService.findBydate(date);
	}
	
	@UserLoginToken
	@GetMapping("/listAttendance/{id}")
	@ResponseBody
	public List<AttendanceDao>  findBydate(@PathVariable("id") int id) {
		return attendanceService.findByID(id);
	}
	
	@UserLoginToken
	@GetMapping("/listAttendance/{id}/{date}")
	@ResponseBody
	public List<AttendanceDao>  findByIdAndDate(@PathVariable("id") int id,@PathVariable("date") Date date) {
		return attendanceService.findByIdAndDate(id,date);
	}

}
