package com.pyz.basic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public abstract class BasicServiceImp implements BasicServiceInter {
	
	@Resource
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
//通过Id查找对象
	@Override
	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(clazz, id);
	}
	//通过hql语句查找对象
	@Override
	public List executeQuery(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null && parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				
				query.setParameter(i,parameters[i]);
			}
			
		}
		
		return query.list();
	}
	
	@Override
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pageSize) {
		// TODO Auto-generated method stub
	
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
	
		if(parameters!=null && parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
			
				query.setParameter(i,parameters[i]);
			}
			
		}
		
		// 分页 
		return query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize).list();
	}

	@Override
	public Serializable add(Object obj) {
		// TODO Auto-generated method stub
	return this.sessionFactory.getCurrentSession().save(obj);
	
	}

	@Override
	public int executeUpdate(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
		}
		return query.executeUpdate();
	}

	@Override
	public Object uniqueQuery(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null && parameters.length!=0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setParameter(i, parameters[i]);
			}
		}
		//得到唯一对象
		return query.uniqueResult();
	}

	@Override
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		// TODO Auto-generated method stub
		Object obj=this.uniqueQuery(hql, parameters);
		int rowCount = Integer.parseInt(obj.toString());
		return (rowCount-1)/pageSize+1;

	}

	@Override
	public void delById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(this.findById(clazz, id));
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(obj);
		}

}
