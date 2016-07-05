package com.bzu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bzu.dao.impl.CourseDao;
import com.bzu.dao.impl.StudentDao;
import com.bzu.dao.inter.StudentDaoInter;
import com.bzu.entity.Course;
import com.bzu.entity.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	private Student stu;

	private Course course;

	private File file;

	private String fileFileName;

	private String fileContentType;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	StudentDaoInter dao = new StudentDao();

	@SuppressWarnings("deprecation")
	public void upload() {

		String root = ServletActionContext.getRequest().getRealPath("/upload");

		try {
			InputStream is = new FileInputStream(file);
			// ����һ���ļ���·��Ϊroot���ļ�����fileFileName

			fileFileName = System.currentTimeMillis()
					+ fileFileName.substring(fileFileName.lastIndexOf("."));
			
			System.out.println(fileFileName);

			File destFile = new File(root, fileFileName);
			// ���ļ������ָ����Ŀ¼
			System.out.println(destFile.getAbsolutePath());
			// ��ʼ�ϴ�
			OutputStream os = new FileOutputStream(destFile);

			byte[] buffer = new byte[50000];

			int length = 0;
			// enctype="multipart/form-data"
			while (-1 != (length = is.read(buffer))) {
				os.write(buffer, 0, length);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			is.close();
			os.close();
		} catch (IOException ex) {

			ex.printStackTrace();
		}
		// �����ݲ������ݿ�

	}

	public void validateCheckStudent() {
		System.out.println("��֤��ʼ");
		System.out.println(stu.getIdCard());
		if (stu.getIdCard() == null||"".equals(stu.getIdCard())){
			System.out.println("add idcard");
			this.addFieldError("idCard", getText("idCard.null"));
		}
		if (stu.getPassword() == null||"".equals(stu.getPassword()))
			this.addFieldError("password", getText("password.null"));
		if (stu.getPassword().length() < 1 || stu.getIdCard().length() < 1)
			this.addFieldError("length", getText("length"));

	}
	
	public String exists() throws Exception{
		System.out.println("1122");
		boolean boo=dao.exists(stu.getIdCard());
		  //��ȡԭʼ��PrintWriter����,�Ա������Ӧ���,��������ת��ĳ����ͼ    
        HttpServletResponse response = ServletActionContext.getResponse();    
        //�����ַ���    
        response.setCharacterEncoding("UTF-8");    
        PrintWriter out = response.getWriter();    
		if(boo){
        
        //ֱ��������Ӧ������    
        out.println("*ѧ���Ѵ���*");    
        /**��ʽ�����ʱ��**/   
        out.flush();    
        out.close();    
		}
		out.println("*ѧ�ſ���*"); 
		return null;
		
	}
	public String checkStudent() {// ��֤ѧ��ǰ̨��½

		Student stu_info = dao.checkStu(stu);

		ServletActionContext.getRequest().getSession().setAttribute("stu_info",
				stu_info);
		return stu_info != null ? "success" : "input";
	}

	public String updateStu() throws Exception {// ѧ���Լ��޸���Ϣ
		upload();
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		System.out.println(fileFileName);
		stu.setPhotopath(fileFileName);

		//stu
		//		.setMajor(new String(stu.getMajor().getBytes("ISO-8859-1"),
		//				"UTF-8"));
		//stu.setName(new String(stu.getName().getBytes("ISO-8859-1"), "UTF-8"));
		stu.setCourses(new CourseDao().getCourse(Student.class, stu.getId()));
		if (dao.update(stu)) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"stu_info", stu);
			return "success";
		} else
			return INPUT;
	}

	public String deleCourse() {// ѧ���˿�

		Student student = (Student) ServletActionContext.getRequest()
				.getSession().getAttribute("stu_info");

		student = dao.getStu(Student.class, student.getId());
		Set<Course> set = student.getCourses();
		for (Iterator<Course> it = set.iterator(); it.hasNext();) {

			Course cou = it.next();
			if (cou.getId() == course.getId())
				it.remove();
		}

		student.setCourses(set);
		dao.update(student);
		return "success";
	}

	public String addCourse() {// ѧ��ѡ��

		Student student = (Student) ServletActionContext.getRequest()
				.getSession().getAttribute("stu_info");

		student = dao.getStu(Student.class, student.getId());
		Set<Course> set = student.getCourses();
		Course cour = new CourseDao().getCour(Course.class, course.getId());
		student.getCourses().add(cour);
		dao.update(student);
		return "success";

	}

	public String deleteStu() {// ����Աɾ��ѧ��

		stu = dao.getStu(Student.class, stu.getId());
		stu.setCourses(null);
		if (dao.delete(stu))
			return "operaSuccess";
		return "operaFail";
	}

	public String addStu() throws Exception {// ����Ա��ӻ����޸�ѧ����Ϣ
		System.out.println("111111111122");
		upload();
		System.out.println("111111111111111");
		stu.setPhotopath(fileFileName);
		// stu
		// .setMajor(new String(stu.getMajor().getBytes("ISO-8859-1"),
		// "UTF-8"));
		// stu.setName(new String(stu.getName().getBytes("ISO-8859-1"),
		// "UTF-8"));
		System.out.println(stu.getName() + " ___________________"
				+ stu.getMajor());
		if (stu.getId() == 0) {
			if (dao.addStu(stu))
				return "operaSuccess";
		} else if (dao.update(stu))
			return "operaSuccess";
		return "operaFail";
	}

	public String updateStuDialog() {// ��ù���Ա�޸�ѧ����Ϣ����

		stu = dao.getStu(Student.class, stu.getId());
		ServletActionContext.getRequest().setAttribute("stu_info", stu);
		System.out.println("updateStuDialog");
		return "showdialog";

	}

}
