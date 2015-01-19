package com.edu.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.edu.bean.PageBean;
import com.edu.domain.User;
import com.edu.service.UserService;
import com.opensymphony.xwork2.ActionContext;

@Controller
public class UserAction  {
	//当前页
	private int pageNum = 1;
	//每页显示多少条
	private int pageSize = 10;
	
	@Resource
	private UserService userService;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String list() throws Exception{
		System.out.println(pageSize);
		System.out.println(pageNum);
		PageBean<User> page = userService.getPageBean(pageNum, pageSize);
		ActionContext.getContext().getValueStack().push(page);
		return "list";
	}

}
