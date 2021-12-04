package com.group18.dao;

import java.util.List;

import com.group18.po.ClientQualification;

public interface IClientQualificationDAO {
	public List findByHql(String hql);
	public void save(ClientQualification clientQualification);//保存业主资质信息
	public void update(ClientQualification clientQualification);//修改业主资质信息
	public void delete(ClientQualification clientQualification);//删除业主资质信息
}
