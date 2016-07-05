package com.bzu.dao.inter;

import java.io.Serializable;

import com.bzu.entity.Adminer;
import com.bzu.entity.Student;

public interface AdminDaoInter {
	
/**
 * ��֤��½�Ĺ���Ա��Ϣ�Ƿ���ȷ
 * @param admin ��½�Ĺ���Ա��Ϣ
 * @return ����Ա��Ϣ�Ƿ���ȷ
 */
	public abstract Adminer checkAdminer(Adminer admin);
	
	/**
	 * �ж���ӵĹ���Ա���û����Ƿ����
	 * 
	 * @param username �û���
	 * @return �û����Ƿ����
	 */

	public abstract boolean exists(String username);
	
	/**��ӹ���Ա
	 * @param entity ��ӵĹ���Ա��Ϣ
	 * @return �Ƿ���ӳɹ�
	 */

	public abstract boolean addAdmin(Object entity);
	
	/**
	 * ��ö�Ӧid��ѧ������
	 * @param clazz ��õ�class����
	 * @param id ����
	 * @return
	 */

	public abstract Student getStu(Class clazz, Serializable id);
	
	/**
	 * 
	 * ���¹���Ա��Ϣ
	 * @param entity ��Ҫ���µĹ���Ա��Ϣ
	 * @return �Ƿ���ӳɹ�
	 */

	public abstract boolean update(Adminer entity);

}