package com.example.demo.jwt;



import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.Dao.UserDao;


@Service("TokenService")
public class TokenService {
    public String getToken(UserDao emp){
    	String token="";
        token= JWT.create().withAudience(String.valueOf(emp.getEmp_no()))// 将 emp id 保存到 token 里面
                .sign(Algorithm.HMAC256(emp.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}

