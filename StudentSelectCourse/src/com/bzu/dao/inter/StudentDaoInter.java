package com.bzu.dao.inter;

import java.io.Serializable;
import java.util.List;

import com.bzu.entity.Student;

public interface StudentDaoInter {
	/**
	 * 验证登陆的学生用户名和密码是否正确
	 * @param stu 所要验证的学生对象
	 * @return 验证的学生对象信息
	 */

	public abstract Student checkStu(Student stu);
	
	/**
	 * 判断所要添加的学号是否存在
	 * @param idCard 所要判断的学号
	 * @return 学号是否存在
	 */

	public abstract boolean exists(String idCard);
	
	
	/**
	 * 获得对应的页码的数据集合
	 * @param index 所要查询的页码
	 * @param  clazz 查询的对象的class类型
	 * @param hql 高级查询的hql语句
	 * @return 所要查询的当前页的集合
	 */
	public abstract List<Object> pageList(int index, Class clazz, String hql);
	
/**
 * 获得对应id的学生对象
 * @param clazz 查询的对象的class类型
 * @param id 主键
 * @return 查询对应的实体类
 */

	public abstract Student getStu(Class clazz, Serializable id);
	/**
	 * 修改学生信息
	 * @param entity 所要更新的实体类
	 * @return 是否更新成功
	 */
	public abstract boolean update(Student entity);
	
	/**
	 * 删除学生
	 * @param entity 所要删除的对象
	 * @return 是否删除成功
	 */


	public abstract boolean delete(Student entity);
	
	/**添加学生
	 * @param entity 添加的学生信息
	 * @return 是否添加成功
	 */
	public abstract boolean addStu(Student entity);
	

}