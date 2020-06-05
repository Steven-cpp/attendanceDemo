package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dao.UserDao;
import com.example.demo.Service.UserService;
import com.example.demo.jwt.TokenService;
import com.example.demo.jwt.annot.UserLoginToken;

import net.minidev.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	UserService  UserService ;
	@Autowired
    TokenService tokenService;
	
	@PostMapping("/register")
	@ResponseBody
	public String addEmployee( @RequestParam("empNo")int empNo, @RequestParam("position") String position, 
			@RequestParam("name")String name, @RequestParam("password")String passwd,
			@RequestParam("email")String email,@RequestParam("id_number")String id_number,
			@RequestParam("department")String department,@RequestParam("sex")String sex,@RequestParam("age")int age) {
		
		UserService.insertEmployee(empNo, position, name, passwd,email, id_number,department,age,sex);	
		return "注册成功";
	}
    //登录
    @PostMapping("/login")
    @ResponseBody
    public Object login( @RequestParam(value="empNo",required=false)int empNo,@RequestParam("password")String passwd){
        JSONObject jsonObject=new JSONObject();
        UserDao userForBase=UserService.findEmpById(empNo);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
//        	return"登录失败,用户不存在";
        }else {
            if (!userForBase.getPassword().equals(passwd)){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
//            	return "登录失败,密码错误";
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
//                return "token"+token;               
            }
        }
    }
    
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

    
}
