package logicTier.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import logicTier.dto.ListBean;
import logicTier.dto.Recipe;
import logicTier.service.UserService;
import spark.Request;
import spark.Response;

@Controller
@RequestMapping(value = "/recipe", method = RequestMethod.GET)

public class RestController {

	@Autowired
	UserService userService;
	public RestController(UserService userService){
		this.userService = userService;
	}
	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
	public Recipe show(@PathVariable int id, Request request,
			Response response){
		try{
			return userService.getUserInfo(id);
		}catch(Exception e){
			id = 0;
			e.printStackTrace();
			return userService.getUserInfo(id);
		}

	}

	@RequestMapping(value = "/json/list", method = RequestMethod.POST)
	public ListBean getAll(Request request,Response response) throws Exception {
		return userService.getAllUsers();

	}

}
