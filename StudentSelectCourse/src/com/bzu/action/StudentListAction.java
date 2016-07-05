package com.bzu.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.bzu.dao.impl.StudentDao;
import com.bzu.dao.inter.StudentDaoInter;
import com.bzu.entity.Student;
import com.bzu.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class StudentListAction extends ActionSupport {

	private final int EVpAGECOUNT = 10;
	private int index;
	
	private Student stu;
	
	private String startTime;
	private String endTime;
	
	

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	StudentDaoInter dao = new StudentDao();

	public String execute() {
		
		
		System.out.println((stu==null)+"sssssssssssssssssssss");
		
		String hql="";
		
		if(stu!=null){
			String name = null;
			String major=null;
			try {
				name = new String((stu.getName().getBytes("ISO8859-1")),"UTF-8");
				major= new String((stu.getMajor().getBytes("ISO8859-1")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(name!=null&&!("".equals(name)))
			hql+=" and s.name like '%"+name+"%'";
		if(major!=null&&!("".equals(major)))
			hql+=" and s.name like '%"+major+"%'";
		if(stu.getIdCard()!=null&&!("".equals(stu.getIdCard())))
			hql+=" and s.idCard like '%"+stu.getIdCard()+"%'";
		if(startTime!=null && endTime!=null&&!("".equals(startTime))&&!("".equals(endTime)))
			hql+=" and s.birthday between '"+startTime+"' and '"+endTime+"'";
		}
		List<Object> list = index != 0 ? dao.pageList(index, Student.class,hql)
				: dao.pageList(1, Student.class,hql);
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list",list);
		session.setAttribute("thisindex",index==0?1:index);
		
		Session session1 = HibernateUtil.getSession();
		session1.beginTransaction();
		session.setAttribute("count",session1.createQuery("from Student").list().size());
		return SUCCESS;

	}
}
