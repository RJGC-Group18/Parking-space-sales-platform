package com.group18.service;

import java.util.List;

import com.group18.po.User;
import com.group18.po.UserQualification;

public interface IUserQualificationService {
	public void add(UserQualification userQualification);//添加销售方资质信息
	public void update(UserQualification userQualification);//更新销售方资质信息
	public void delete(UserQualification userQualification);//删除销售方资质信息
	public List<UserQualification> findByUid(User user);//通过销售方id查找销售方资质信息
	public UserQualification findByQid(UserQualification userQualification);//通过销售方资质id查找销售方资质信息
}
