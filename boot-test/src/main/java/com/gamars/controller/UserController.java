package com.gamars.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamars.dao.UserMapper;

@SpringBootApplication
@RestController
public class UserController {
    @Autowired
    private UserMapper mapper;
     
    String resultmsg="";
     
    @RequestMapping(value="/usercheck",method=RequestMethod.POST)
    public  Map<String,Object> checkid(HttpServletRequest request) throws Exception{
        int cnt = mapper.checkId(request.getParameter("mId"));
         
        Map<String, Object> jsonObject = new HashMap<String, Object>();
         
        if(cnt==0){
            resultmsg="ID can be used";
        }else{
            resultmsg="ID not available";
        }
         
        jsonObject.put("resultmsg", resultmsg);
         
        return jsonObject;
    }
     
}