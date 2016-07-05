package com.bzu.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.bzu.dao.impl.CourseDao;
import com.bzu.dao.inter.CourseDaoInter;
import com.bzu.entity.Course;
import com.bzu.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CourseListAction extends ActionSupport {

	private final int EVpAGECOUNT = 10;
	private int index;

	private Course course;

	private int startHour;
	private int endHour;

	private int flag;

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	CourseDaoInter dao = new CourseDao();

	public String execute() {
		String hql = "";
		if (course != null) {
			if (course.getName() != null && !("".equals(course.getName())))
				hql += " and s.name like '%" + course.getName() + "%'";
			if (course.getId() != 0)
				hql += " and s.id =" + course.getId();
			if (course.getLessonTime() != 0)
				hql += " and s.lessonTime =" + course.getLessonTime();
			if (course.getLessonPoints() != 0)
				hql += " and s.lessonPoints =" + course.getLessonPoints();
			if (startHour != 0 && endHour != 0 && !("".equals(startHour))
					&& !("".equals(endHour)))
				hql += " and s.lessonHour between '" + startHour + "' and '"
						+ endHour + "'";

		}
		List<Object> list = index != 0 ? dao.pageList(index, Course.class, hql)
				: dao.pageList(1, Course.class, hql);

		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		session.setAttribute("thisindex", index == 0 ? 1 : index);

		Session session1 = HibernateUtil.getSession();
		session1.beginTransaction();
		session.setAttribute("coucount", session1.createQuery("from Course")
				.list().size());
		System.out.println(session1.createQuery("from Course").list().size()
				+ ".............................");
		if (flag != 0)
			return "front";
		else
			return "behind";

	}
}
