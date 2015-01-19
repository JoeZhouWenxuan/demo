package com.edu.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 查询辅助类
 * @author zhou_wenxuan
 *
 */
public class QueryHelper {
	/**
	 * from 子句
	 */
	private String fromClause;
	/**
	 * where 子句
	 */
	private String whereClause = "";
	/**
	 * order by 子句
	 */
	private String orderByClause = "";
	
	/**
	 * 参数列表
	 */
	private List<Object> parameters = new ArrayList<Object>();
		
	public String getFromClause() {
		return fromClause;
	}


	public void setFromClause(String fromClause) {
		this.fromClause = fromClause;
	}


	public String getWhereClause() {
		return whereClause;
	}


	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}


	public String getOrderByClause() {
		return orderByClause;
	}


	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * 构造对象传入要查询的类型的Class属性以及别名
	 * @param clazz
	 * @param alias
	 */
	public QueryHelper(Class clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
		
	}
	/**
	 * 添加查询条件
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(String condition, Object... params){
		if(whereClause.length() == 0){
			whereClause = "WHERE " + condition;
			
		}else{
			whereClause = " AND " + condition;
			
		}
		
		if(params != null){
			for(Object o : params){
				parameters.add(o);
			}
		}
		return this;
	}
	/**
	 * 当append为true,添加查询条件
	 *
	 * @param append
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(boolean append, String condition, Object... params){
		if(append){
			addCondition(condition, params);
		}
		return this;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param asc
	 */
	public QueryHelper addOrderProperty(String propertyName, boolean asc){
		if(orderByClause.length() == 0){
			orderByClause = " ORDER BY " + propertyName + (asc ? " ASC" : " DESC"); 
		}else{
			orderByClause = ", " + propertyName + (asc ? " ASC" : " DESC");
		}
		return this;
	}
	
	/**
	 * 
	 * @param append
	 * @param propertyName
	 * @param asc
	 * @return
	 */
	public QueryHelper addOrderProperty(boolean append, String propertyName, boolean asc){
		if(append){
			addOrderProperty(propertyName, asc);
		}
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getListQueryHql(){
		return fromClause + whereClause + orderByClause;
	}
	/**
	 * 
	 * @return
	 */
	public String getCountQueryHql(){
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Object> getParameters(){
		return parameters;
	}
	

}
