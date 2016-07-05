package com.bzu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bzu.dao.impl.AdminerDao;
import com.bzu.dao.inter.AdminDaoInter;
import com.bzu.entity.Adminer;
import com.opensymphony.xwork2.ActionSupport;

public class AdminerAction extends ActionSupport {

	private Adminer admin;

	public Adminer getAdmin() {
		return admin;
	}

	public void setAdmin(Adminer admin) {
		this.admin = admin;
	}

	AdminDaoInter dao = new AdminerDao();

	public String exists() throws Exception{
		System.out.println(admin==null);
		boolean boo=dao.exists(admin.getUsername());
		  //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
        HttpServletResponse response = ServletActionContext.getResponse();    
        //�����ַ���    
        response.setCharacterEncoding("UTF-8");    
        PrintWriter out = response.getWriter();    
		if(boo){
			     
        
        //ֱ��������Ӧ������    
        out.println("*�û����Ѵ���*");    
        /**��ʽ�����ʱ��**/   
        out.flush();    
        out.close();    
		}
		out.println("*�û�������*"); 
		return null;
		
	}

	public String checkAdminer() {
		Adminer admin_info = dao.checkAdminer(admin);
		ServletActionContext.getRequest().getSession().setAttribute(
				"admin_info", admin_info);
		return admin_info != null ? "success" : "input";
	}

	public String addAdmin() throws Exception {
		admin.setName(new String(admin.getName().getBytes("ISO-8859-1"),
				"UTF-8"));
		dao.addAdmin(admin);

		return SUCCESS;
	}

	public String updateAdmin() throws Exception {

		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");

		admin.setName(new String(admin.getName().getBytes("ISO-8859-1"),
				"UTF-8"));
		System.out.println(admin);
		if (dao.update(admin)) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"stu_info", admin);
			return "success";
		} else
			return INPUT;
	}

}
