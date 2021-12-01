package com.group18.dao;

import java.util.List;

import com.group18.po.Dealing;

public interface IDealingDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(Dealing dealing);//添加交易信息
	public void update(Dealing dealing);//修改交易信息
	public void delete(Dealing dealing);//删除交易信息
}
