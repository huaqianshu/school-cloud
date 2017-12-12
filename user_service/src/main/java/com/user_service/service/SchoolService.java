package com.user_service.service;
import com.school.base.messanger.Result;
public interface SchoolService {
	Result findbyName(String name);
	Result findAll();
}
