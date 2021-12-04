package com.group18.dao;

import java.util.List;

import com.group18.po.UserQualification;

public interface IUserQualificationDAO {
	public List findByHql(String hql);
	public void save(UserQualification userQualification);//保存销售方资质信息
	public void update(UserQualification userQualification);//修改销售方资质信息
	public void delete(UserQualification userQualification);//删除销售方资质信息
}
