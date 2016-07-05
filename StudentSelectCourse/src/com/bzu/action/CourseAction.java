package com.bzu.action;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.bzu.dao.impl.CourseDao;
import com.bzu.dao.inter.CourseDaoInter;
import com.bzu.entity.Course;
import com.bzu.entity.Student;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {

	private Student stu;

	private Course cour;

	public Course getCour() {
		return cour;
	}

	public void setCour(Course cour) {
		this.cour = cour;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	CourseDaoInter dao = new CourseDao();

	public String getCourse() {

		Set<Course> set = dao.getCourse(Student.class, stu.getId());
		ServletActionContext.getRequest().getSession().setAttribute("set", set);
		return SUCCESS;

	}

	public String deleCourse() {

		cour = dao.getCour(Course.class, cour.getId());
		cour.setStudents(null);
		if (dao.delete(cour))
			return "operaSuccess";

		else
			return "operaFail";

	}

	public String updateCourDialog() {

		cour = dao.getCour(Course.class, cour.getId());
		ServletActionContext.getRequest().setAttribute("cour_info", cour);
		return "showdialog";

	}

	public String updateCour() throws Exception {
		cour
				.setName(new String(cour.getName().getBytes("ISO-8859-1"),
						"UTF-8"));

		if (cour.getId() != 0)
			if (dao.updateCour(cour))
				return "operaSuccess";

			else
				System.out.println(cour);
		if (dao.addCour(cour))
			return "operaSuccess";

		return "operaFail";
	}

}
