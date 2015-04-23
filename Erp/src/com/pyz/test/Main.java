package com.pyz.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pyz.domain.Admin;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List list = new ArrayList();
		Admin a1 = new Admin();
		a1.setId("1");
		a1.setUserName("abc");
		a1.setPassword("123123");
		list.add(a1);
		
		Admin a2 = new Admin();
		a2.setId("2");
		a2.setUserName("abc2");
		a2.setPassword("123123");
		list.add(a2);
		
		String obj = JSONArray.fromObject(list).toString();
		System.out.println(obj);
		
	}

}
