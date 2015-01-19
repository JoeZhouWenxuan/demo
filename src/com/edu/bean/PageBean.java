package com.edu.bean;

import java.util.List;
/**
 * 分页javaBean
 * 包括：
 * 	>>
 * 	页面数据    
	当前页     
	页面大小    
	记录数     
	页面数     
	页码列表开始索引
 * 	
 * @author zhou_wenxuan
 *
 */
public class PageBean<T> {
	
	
	//设置数据或者通过参数获得
	private int currentPage = 1		;	//当前页
	private int pageSize = 10		;	//页面大小
	
	//数据库查询
	private List<T> recordList		;	//页面数据
	private int recordCount		;	//记录数
	
	//计算出来的数据
	private int pageCount		;	//页面数
	private int beginPageIndex	; 	//页码列表开始索引
	private int endPageIndex	;	//页码列表结束索引
	
	
	public PageBean(int currentPage, int pageSize, List<T> recordList, int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;
		
		
		
		//计算总页码
		this.pageCount = (recordCount + pageSize - 1) / pageSize;
		
		if(this.currentPage > pageCount){
			this.currentPage = pageCount;
		}
		if(this.currentPage < 0){
			this.currentPage = 0;
		}
		//计算页码开始索引和结束索引
		//总页数不多于10页，则全部显示
		if(this.pageCount <= 10){
			this.beginPageIndex = 1;
			this.endPageIndex = this.pageCount;
			
		}
		//总页数多于10页，则显示当前页附近的共10个页码
		else{
			//当前页附近10个页码
			this.beginPageIndex = this.currentPage - 4;
			this.endPageIndex = this.currentPage + 5;
			//当前面的页码不足4个时，则显示前10个页码
			if(this.beginPageIndex < 1){
				this.beginPageIndex = 1;
				this.endPageIndex = 10;
			}
			//当后面的页码不足5个时，则显示后10个页码
			if(this.endPageIndex > this.pageCount){
				this.endPageIndex = this.pageCount;
				this.beginPageIndex = this.pageCount - 10 + 1;
			}
			
		}
			
		
		
		
	}
	public List<T> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage > pageCount){
			currentPage = pageCount;
		}
		if(currentPage < 0){
			currentPage = 0;
		}
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
	
	
}
