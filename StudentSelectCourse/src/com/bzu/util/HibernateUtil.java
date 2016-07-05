package com.bzu.util;

import java.io.Serializable;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bzu.entity.Student;
/**
 * 
 *
 *
 */
public class HibernateUtil {

	private HibernateUtil() {
	}

	private static SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// static {
	// Configuration config = new Configuration();
	// config.configure();
	// seFactory = config.buildSessionFactory();
	// }
	//
	// public static void setSeFactory(SessionFactory seFactory) {
	// HibernateUtil.seFactory = seFactory;
	// }
	//
	// 得到session
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	// 增加操作
	public static boolean add(Object entity) {
		Session s = null;
		Transaction tran = null;
		boolean temp = false;
		try {
			s = HibernateUtil.getSession();
			tran = s.beginTransaction();
			s.save(entity);
			tran.commit();
			temp = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}

		return temp;
	}

	// 删除操作
	public static boolean delete(Object entity) {
		Session s = null;
		Transaction tran = null;
		boolean temp = false;
		try {
			s = HibernateUtil.getSession();
			tran = s.beginTransaction();
			System.out.println(entity == null);
			s.delete(entity);
			tran.commit();
			temp = true;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return temp;
	}

	// 更新操作
	public static boolean update(Object entity) {
		Session s = null;
		Transaction tran = null;
		boolean temp = false;
		try {
			s = HibernateUtil.getSession();
			tran = s.beginTransaction();
			s.update(entity);
			tran.commit();
			temp = true;

		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}

		return temp;
	}

	// session查询操作
	public static Object select(Class clazz, Serializable id) {
		Session s = null;
		//Transaction tran = null;
		Object obj = null;
		try {
			s = HibernateUtil.getSession();
		//	tran = s.beginTransaction();
			obj = s.get(clazz, id);
		//	tran.commit();
		} catch (Exception e) {
		//	tran.rollback();
		}
		s.close();
		return obj;
	}

	// select login-user
	public static Object check(String hql, Object[] condition) {
		Session s = null;
		Transaction tran = null;
		Object obj = null;
		try {
			s = HibernateUtil.getSession();
			tran = s.beginTransaction();
			Query query = s.createQuery(hql);
			if (condition.length != 0)
				for (int i = 0; i < condition.length; i++)
					query.setParameter(i, condition[i]);
			obj = query.uniqueResult();
			tran.commit();
		} catch (Exception e) {
			//tran.rollback();
			e.printStackTrace();
		}
		return obj;
	}

	public static List<Object> selectPage(int index, Class clazz, String bhql) {

		final int PAGETOTAL = 10;
		Session session = null;
		Transaction tran = null;
		List<Object> list = null;

		try {
			session = HibernateUtil.getSession();
			tran = session.beginTransaction();
			System.out.println(clazz.getName());
			String hql = "from " + clazz.getName() + " as s where 1=1" + bhql;
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setFirstResult((index - 1) * PAGETOTAL);
			query.setMaxResults(PAGETOTAL);
			list = query.list();
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println("002".equals("002"));
		
	}
}
