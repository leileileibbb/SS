package com.bzu.dao.inter;

import java.io.Serializable;
import java.util.List;

import com.bzu.entity.Student;

public interface StudentDaoInter {
	/**
	 * ��֤��½��ѧ���û����������Ƿ���ȷ
	 * @param stu ��Ҫ��֤��ѧ������
	 * @return ��֤��ѧ��������Ϣ
	 */

	public abstract Student checkStu(Student stu);
	
	/**
	 * �ж���Ҫ��ӵ�ѧ���Ƿ����
	 * @param idCard ��Ҫ�жϵ�ѧ��
	 * @return ѧ���Ƿ����
	 */

	public abstract boolean exists(String idCard);
	
	
	/**
	 * ��ö�Ӧ��ҳ������ݼ���
	 * @param index ��Ҫ��ѯ��ҳ��
	 * @param  clazz ��ѯ�Ķ����class����
	 * @param hql �߼���ѯ��hql���
	 * @return ��Ҫ��ѯ�ĵ�ǰҳ�ļ���
	 */
	public abstract List<Object> pageList(int index, Class clazz, String hql);
	
/**
 * ��ö�Ӧid��ѧ������
 * @param clazz ��ѯ�Ķ����class����
 * @param id ����
 * @return ��ѯ��Ӧ��ʵ����
 */

	public abstract Student getStu(Class clazz, Serializable id);
	/**
	 * �޸�ѧ����Ϣ
	 * @param entity ��Ҫ���µ�ʵ����
	 * @return �Ƿ���³ɹ�
	 */
	public abstract boolean update(Student entity);
	
	/**
	 * ɾ��ѧ��
	 * @param entity ��Ҫɾ���Ķ���
	 * @return �Ƿ�ɾ���ɹ�
	 */


	public abstract boolean delete(Student entity);
	
	/**���ѧ��
	 * @param entity ��ӵ�ѧ����Ϣ
	 * @return �Ƿ���ӳɹ�
	 */
	public abstract boolean addStu(Student entity);
	

}