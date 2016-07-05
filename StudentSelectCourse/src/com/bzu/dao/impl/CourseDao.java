package com.bzu.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bzu.dao.inter.CourseDaoInter;
import com.bzu.entity.Course;
import com.bzu.entity.Student;
import com.bzu.util.HibernateUtil;

public class CourseDao implements CourseDaoInter {

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.CourseDaoInter#pageList(int, java.lang.Class, java.lang.String)
	 */
	public List<Object> pageList(int index, Class clazz, String hql) {

		return HibernateUtil.selectPage(index, clazz, hql);

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.CourseDaoInter#getCour(java.lang.Class, java.io.Serializable)
	 */
	public Course getCour(Class clazz, Serializable id) {

		return HibernateUtil.select(clazz, id) != null ? (Course) HibernateUtil
				.select(clazz, id) : null;

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.CourseDaoInter#getCourse(java.lang.Class, java.io.Serializable)
	 */
	public Set<Course> getCourse(Class clazz, Serializable id) {

		Set<Course> set = new HashSet<Course>();
		Student stu = null;
		if (HibernateUtil.select(clazz, id) != null) {
			stu = (Student) HibernateUtil.select(clazz, id);
			set = stu.getCourses();
			return set;
		}

		else
			return null;

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.CourseDaoInter#delete(com.bzu.entity.Course)
	 */
	public boolean delete(Course cour) {

		return HibernateUtil.delete(cour);

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.CourseDaoInter#updateCour(com.bzu.entity.Course)
	 */
	public boolean updateCour(Course cour) {

		return HibernateUtil.update(cour);

	}

	/* (non-Javadoc)
	 * @see com.bzu.dao.impl.CourseDaoInter#addCour(com.bzu.entity.Course)
	 */
	public boolean addCour(Course cour) {

		return HibernateUtil.add(cour);

	}
}
