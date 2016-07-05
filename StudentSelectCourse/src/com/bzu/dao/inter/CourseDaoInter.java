package com.bzu.dao.inter;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import com.bzu.entity.Course;

public interface CourseDaoInter {

	/**
	 * ��÷�ҳ��ѯ�ĵ�ǰҳ�Ľ��
	 * 
	 * @param index  ��Ҫ��ѯ�ĵ�ǰҳ
	 * @param  clazz ��ѯ��Ӧ��class����
	 * @param  hql ģ����ѯ��Ӧ��hql���
	 * @return ��ѯ��indexҵ�ļ���
	 */
	public abstract List<Object> pageList(int index, Class clazz, String hql);
	
	
/**
 * ��ö�Ӧid�Ŀγ̶���
 * @param clazz ��ѯ��Ӧ��class����
 * @param id ����
 * @return ��Ҫ��õ�course����
 */
	public abstract Course getCour(Class clazz, Serializable id);
	
	/**
	 * ���ѧ����ѡ�εļ���
	 * @param  clazz ӵ�иü��϶�Ӧ��class��
	 * @param id class�������
	 * @return
	 */
	
	
	public abstract Set<Course> getCourse(Class clazz, Serializable id);
	

	
	/**
	 * ɾ���γ�
	 * @param cour ��Ҫɾ���Ķ���
	 * @return �Ƿ�ɾ���ɹ�
	 */

	public abstract boolean delete(Course cour);
	
	/**
	 * �޸Ŀγ���Ϣ
	 * @param cour ��Ҫ���µ�ʵ����
	 * @return �Ƿ���³ɹ�
	 */

	public abstract boolean updateCour(Course cour);
	
	/**
	 * ��ӿγ�
	 * @param cour ��Ҫ��ӵ�ʵ����
	 * @return
	 */

	public abstract boolean addCour(Course cour);

}