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
		  //获取原始的PrintWriter对象,以便输出响应结果,而不用跳转到某个试图    
        HttpServletResponse response = ServletActionContext.getResponse();    
        //设置字符集    
        response.setCharacterEncoding("UTF-8");    
        PrintWriter out = response.getWriter();    
		if(boo){
			     
        
        //直接输入响应的内容    
        out.println("*用户名已存在*");    
        /**格式化输出时间**/   
        out.flush();    
        out.close();    
		}
		out.println("*用户名可用*"); 
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
