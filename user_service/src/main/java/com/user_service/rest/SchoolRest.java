package com.user_service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.base.messanger.Result;
import com.user_service.service.SchoolService;


@RestController
@RequestMapping("/schoolshoping/school")
public class SchoolRest {
	@Autowired
	@Qualifier("SchoolService")
	private SchoolService schoolService;
	@RequestMapping(value="getSchoolId")
	public Result getSchoolId(@RequestParam("name")String name){
		return schoolService.findbyName(name);
	}
	@RequestMapping(value="getAllSchool")
	public Result findAll(){
		return schoolService.findAll();
	}
}
