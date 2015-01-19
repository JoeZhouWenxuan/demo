package com.edu.bean;

import java.util.List;
/**
 * ��ҳjavaBean
 * ������
 * 	>>
 * 	ҳ������    
	��ǰҳ     
	ҳ���С    
	��¼��     
	ҳ����     
	ҳ���б�ʼ����
 * 	
 * @author zhou_wenxuan
 *
 */
public class PageBean<T> {
	
	
	//�������ݻ���ͨ���������
	private int currentPage = 1		;	//��ǰҳ
	private int pageSize = 10		;	//ҳ���С
	
	//���ݿ��ѯ
	private List<T> recordList		;	//ҳ������
	private int recordCount		;	//��¼��
	
	//�������������
	private int pageCount		;	//ҳ����
	private int beginPageIndex	; 	//ҳ���б�ʼ����
	private int endPageIndex	;	//ҳ���б��������
	
	
	public PageBean(int currentPage, int pageSize, List<T> recordList, int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;
		
		
		
		//������ҳ��
		this.pageCount = (recordCount + pageSize - 1) / pageSize;
		
		if(this.currentPage > pageCount){
			this.currentPage = pageCount;
		}
		if(this.currentPage < 0){
			this.currentPage = 0;
		}
		//����ҳ�뿪ʼ�����ͽ�������
		//��ҳ��������10ҳ����ȫ����ʾ
		if(this.pageCount <= 10){
			this.beginPageIndex = 1;
			this.endPageIndex = this.pageCount;
			
		}
		//��ҳ������10ҳ������ʾ��ǰҳ�����Ĺ�10��ҳ��
		else{
			//��ǰҳ����10��ҳ��
			this.beginPageIndex = this.currentPage - 4;
			this.endPageIndex = this.currentPage + 5;
			//��ǰ���ҳ�벻��4��ʱ������ʾǰ10��ҳ��
			if(this.beginPageIndex < 1){
				this.beginPageIndex = 1;
				this.endPageIndex = 10;
			}
			//�������ҳ�벻��5��ʱ������ʾ��10��ҳ��
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
