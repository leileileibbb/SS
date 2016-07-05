package com.bzu.dao.inter;

import java.io.Serializable;

import com.bzu.entity.Adminer;
import com.bzu.entity.Student;

public interface AdminDaoInter {
	
/**
 * 验证登陆的管理员信息是否正确
 * @param admin 登陆的管理员信息
 * @return 管理员信息是否正确
 */
	public abstract Adminer checkAdminer(Adminer admin);
	
	/**
	 * 判断添加的管理员的用户名是否存在
	 * 
	 * @param username 用户名
	 * @return 用户名是否存在
	 */

	public abstract boolean exists(String username);
	
	/**添加管理员
	 * @param entity 添加的管理员信息
	 * @return 是否添加成功
	 */

	public abstract boolean addAdmin(Object entity);
	
	/**
	 * 获得对应id的学生对象
	 * @param clazz 获得的class类型
	 * @param id 主键
	 * @return
	 */

	public abstract Student getStu(Class clazz, Serializable id);
	
	/**
	 * 
	 * 更新管理员信息
	 * @param entity 所要更新的管理员信息
	 * @return 是否添加成功
	 */

	public abstract boolean update(Adminer entity);

}