package com.bzu.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.bzu.dao.inter.StudentDaoInter;
import com.bzu.entity.Student;
import com.bzu.util.HibernateUtil;

/**
 * 
 *
 */
public class StudentDao implements StudentDaoInter {

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.StudentDaoInter#checkStu(com.bzu.entity.Student)
	 */
	public Student checkStu(Student stu) {

		Object obj = HibernateUtil.check(
				"from Student s where s.idCard=? and s.password=? ",
				new String[] { stu.getIdCard(), stu.getPassword() });
		return obj != null ? (Student) obj : null;

	}
/* (non-Javadoc)
 * @see com.bzu.dao.impl.StudentDaoInter#exists(java.lang.String)
 */
public boolean exists(String idCard){
		
		Object obj=HibernateUtil.check("from Student a where a.idCard=?  "
				, new String[]{idCard});
		
		return obj==null?false:true;
		
	}
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.StudentDaoInter#pageList(int, java.lang.Class, java.lang.String)
	 */
	public List<Object> pageList(int index, Class clazz, String hql) {

		return HibernateUtil.selectPage(index, clazz, hql);

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.StudentDaoInter#getStu(java.lang.Class, java.io.Serializable)
	 */
	public Student getStu(Class clazz, Serializable id) {

		return HibernateUtil.select(clazz, id) != null ? (Student) HibernateUtil
				.select(clazz, id)
				: null;

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.StudentDaoInter#update(com.bzu.entity.Student)
	 */
	public boolean update(Student entity) {

		return HibernateUtil.update(entity);

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.StudentDaoInter#delete(com.bzu.entity.Student)
	 */
	public boolean delete(Student entity) {

		return HibernateUtil.delete(entity);

	}
	
	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.StudentDaoInter#addStu(com.bzu.entity.Student)
	 */
	public boolean addStu(Student entity) {

		return HibernateUtil.add(entity);

	}
}
