package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.Customer;
import com.pyz.domain.Type;
import com.pyz.service.inter.TypeServiceInter;

@Service
public class TypeServiceImp extends BasicServiceImp implements TypeServiceInter{

	public List getTypes() {
		// TODO Auto-generated method stub
		String hql ="from Type";
		List<Type> list = this.executeQuery(hql, null);
		List l = new ArrayList();
		for(Type type:list){
			JSONObject obj = new JSONObject();
			obj.put("id",type.getId());
			obj.put("name",type.getName());
			l.add(obj);
		}
		return l;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		String hql ="select count(*) from Type";
		return Integer.parseInt(this.uniqueQuery(hql, null).toString());
	}

	@Override
	public void delTypes(String ids) {
		// TODO Auto-generated method stub
		if(ids.contains(",")){
			String[] tids = ids.split(",");
			for(String id:tids){
				
				this.delById(Type.class, id);
			}
		}else{
			this.delById(Type.class, ids);
		}
	}

}
