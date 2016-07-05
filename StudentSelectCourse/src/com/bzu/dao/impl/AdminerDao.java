package com.bzu.dao.impl;

import java.io.Serializable;

import com.bzu.dao.inter.AdminDaoInter;
import com.bzu.entity.Adminer;
import com.bzu.entity.Student;
import com.bzu.util.HibernateUtil;

public class AdminerDao implements AdminDaoInter {
	
	
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.AdminDaoInter#checkAdminer(com.bzu.entity.Adminer)
	 */
	public Adminer checkAdminer(Adminer admin) {
		
		Object obj=HibernateUtil.check("from Adminer a where a.username=? and a.password=? "
				, new String[]{admin.getUsername(),admin.getPassword()});
		return  obj!=null?(Adminer)obj:null;
		
	}
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.AdminDaoInter#exists(java.lang.String)
	 */
	public boolean exists(String username){
		
		Object obj=HibernateUtil.check("from Adminer a where a.username=?  "
				, new String[]{username});
		
		return obj==null?false:true;
		
	}
	
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.AdminDaoInter#addAdmin(java.lang.Object)
	 */
	public boolean addAdmin(Object entity)
	{
		
		return  HibernateUtil.add(entity);
		
	}
	
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.AdminDaoInter#getStu(java.lang.Class, java.io.Serializable)
	 */
	public Student getStu(Class clazz, Serializable id)
	{
		
		return  HibernateUtil.select(clazz, id)!=null?(Student) HibernateUtil.select(clazz, id):null;
		
	}
	
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.AdminDaoInter#update(com.bzu.entity.Adminer)
	 */
	public  boolean update(Adminer entity) {
		
		
		return HibernateUtil.update(entity);
		
		
	}
}
