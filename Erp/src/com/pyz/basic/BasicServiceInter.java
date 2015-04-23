package com.pyz.basic;

import java.io.Serializable;
import java.util.List;

public interface BasicServiceInter {

	// 通过id单个查询对象
			public Object findById(Class clazz,java.io.Serializable id);
			
			// 查询方法，返回list
			public List executeQuery(String hql,Object []parameters);
			
			// 查询方法，带分页
			public List executeQueryByPage(String hql,Object []parameters,int pageNow,int pageSize);
			
			// 添加对象
			public Serializable add(Object obj);
			
			// 统一的执行hql-->删除,修改
			public int executeUpdate(String hql,Object []parameters);
			
			// 查询，返回一个对象
			public Object uniqueQuery(String hql,Object []parameters);
			
			// 返回pageCount
			public int queryPageCount(String hql,Object []parameters,int pageSize);
			
			// 通过id删除
			public void delById(Class clazz,java.io.Serializable id);
			
			// 修改对象
			public void update(Object obj);
}
