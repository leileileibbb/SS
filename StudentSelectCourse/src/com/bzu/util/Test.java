package com.bzu.util;

import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bzu.entity.Student;

public class Test {
	// ���Է���
	public static void main(String args[]) {
		// UserInfo user=new UserInfo();
		// user.setAddress("asdfklj");
		// user.setBirthday("1992-2-22" );
		// user.setEmail("JZCprogrammer@163.com");
		// user.setName("programmer");
		// user.setPassword("3ab59d8dc72cb3a903daf2db995ccc1e");
		// //
		// // HibernateUtil.add(user);
		// Session s = null;
		// Transaction tran = null;
		// boolean temp = false;
		// try {
		// s = HibernateUtil.getSession();
		// tran = s.beginTransaction();
		// Student stu = new Student("1023110901", "��ʤ��", 1, "�������",
		// "1990-08-25");
		// Student stu2 = new Student("1023110901", "����", 1, "�������",
		// "1990-08-25");
		// Student stu3 = new Student("1023110901", "����", 1, "�������",
		// "1990-08-25");
		// Course course = new Course("java", 1, 50, 5);
		// Course course2 = new Course("c#", 1, 50, 5);
		// Course course3 = new Course("c++", 1, 50, 5);
		//			
		// stu.setPassword("123456");
		// stu.getCourses().add(course);
		// stu.getCourses().add(course2);
		// s.save(stu);
		// tran.commit();
		// } catch (Exception e) {
		// e.printStackTrace();
		// tran.rollback();
		// }

		// SchemaExport ex=new SchemaExport(new Configuration().configure());
		// ex.create(true, true);

		// Locale[] locales = Locale.getAvailableLocales();
		// for (Locale locale : locales) {
		// //
		// System.out.println(locale.getDisplayCountry()+"==="+locale.getCountry());
		// System.out.println(locale.getDisplayLanguage() + "===="
		// + locale.getLanguage());
		// }

		// //��ȡϵͳ��ǰĬ��Locale
		// Locale locale=Locale.getDefault();
		// // Locale locale=Locale.US;
		// //��ȡ��ǰLocale��Ӧ����Դ��
		// ResourceBundle bundle=ResourceBundle.getBundle("hellofile",locale);
		//         
		// String value=bundle.getString("hello");
		// System.out.println(value);

		// Locale locale = Locale.US;
		// ResourceBundle bundle = ResourceBundle
		// .getBundle("caoshenghuan", locale);
		//
		// String value = bundle.getString("hello");
		// String result = MessageFormat.format(value, new Object[] { "��ʤ��" });
		//
		// System.out.println(result);

		
	}
}
