package com.pyz.basic;

import java.io.Serializable;
import java.util.List;

public interface BasicServiceInter {

	// ͨ��id������ѯ����
			public Object findById(Class clazz,java.io.Serializable id);
			
			// ��ѯ����������list
			public List executeQuery(String hql,Object []parameters);
			
			// ��ѯ����������ҳ
			public List executeQueryByPage(String hql,Object []parameters,int pageNow,int pageSize);
			
			// ��Ӷ���
			public Serializable add(Object obj);
			
			// ͳһ��ִ��hql-->ɾ��,�޸�
			public int executeUpdate(String hql,Object []parameters);
			
			// ��ѯ������һ������
			public Object uniqueQuery(String hql,Object []parameters);
			
			// ����pageCount
			public int queryPageCount(String hql,Object []parameters,int pageSize);
			
			// ͨ��idɾ��
			public void delById(Class clazz,java.io.Serializable id);
			
			// �޸Ķ���
			public void update(Object obj);
}
