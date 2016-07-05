package com.bzu.dao.inter;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import com.bzu.entity.Course;

public interface CourseDaoInter {

	/**
	 * 获得分页查询的当前页的结果
	 * 
	 * @param index  所要查询的当前页
	 * @param  clazz 查询对应的class类型
	 * @param  hql 模糊查询对应的hql语句
	 * @return 查询的index业的集合
	 */
	public abstract List<Object> pageList(int index, Class clazz, String hql);
	
	
/**
 * 获得对应id的课程对象
 * @param clazz 查询对应的class类型
 * @param id 主键
 * @return 想要获得的course对象
 */
	public abstract Course getCour(Class clazz, Serializable id);
	
	/**
	 * 获得学生的选课的集合
	 * @param  clazz 拥有该集合对应的class类
	 * @param id class类的主键
	 * @return
	 */
	
	
	public abstract Set<Course> getCourse(Class clazz, Serializable id);
	

	
	/**
	 * 删除课程
	 * @param cour 所要删除的对象
	 * @return 是否删除成功
	 */

	public abstract boolean delete(Course cour);
	
	/**
	 * 修改课程信息
	 * @param cour 所要更新的实体类
	 * @return 是否更新成功
	 */

	public abstract boolean updateCour(Course cour);
	
	/**
	 * 添加课程
	 * @param cour 所要添加的实体类
	 * @return
	 */

	public abstract boolean addCour(Course cour);

}