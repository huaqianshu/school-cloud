package com.user_service.service.impl;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.school.base.entity.School;
import com.school.base.messanger.Result;
import com.user_service.dao.SchoolDao;
import com.user_service.service.SchoolService;

@Configuration
@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;
	@Override
	public Result findbyName(String name){
		School school = schoolDao.findByName(name);
		Result res = new Result(0,"success");
		res.setData(new Document("schoolid",school.getId()));
		return res;
	}
	@Override
	public Result findAll() {
		List<School> list = schoolDao.findAll();
		Result res=new Result(0,"success");
		res.set("schools", list);
		return res;
	}
}
