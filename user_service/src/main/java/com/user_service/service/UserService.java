package com.user_service.service;

import org.bson.Document;

import com.school.base.messanger.Result;


public interface UserService {
	//注册
	Result login(Document doc);
	//登录
	Result register(Document doc);
	//修改资料
	Result edit(Document doc);
	//更新简介
	Result changeIntroduction(String introduction,int userid);
}
