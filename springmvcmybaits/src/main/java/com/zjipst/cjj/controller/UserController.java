package com.zjipst.cjj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zjipst.cjj.model.User;
import com.zjipst.cjj.service.UserService;

@Controller  
@RequestMapping("/user")  
public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@Resource  
    private UserService userService;  
      
    /*@RequestMapping("/showUser")  
    public String toIndex(@RequestBody Integer id, HttpServletRequest request,Model model){  
    	if (id == null) {
    		return "index";
    	}
        User user = this.userService.getUserById(id);  
        model.addAttribute("user", user);  
        return "showUser";  
    }*/
    
    @RequestMapping("/showUser")  
    public ModelAndView showUser(Integer id){  
    	Map<String,Object> model = new HashMap<String,Object>();
        User user = this.userService.getUserById(id);  
        model.put("user", user);
        return new ModelAndView("showUser",model);  
    }
    
    @RequestMapping("/getAllUsers")  
    public List<User> getAllUsers(){  
        return this.userService.getAllUsers();
    }

}
