package com.yy.spring.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Fenye<T> {
	private Integer page;
	private Integer pagesize;
	private Integer total;
	private List<T> rows;
    
    public Orders orders;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Orders getOrder() {
		return orders;
	}
	public void setOrder(Orders orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Fenye [page=" + page + ", pagesize=" + pagesize + ", total=" + total + ", rows=" + rows + ", orders="
				+ orders + "]";
	}
	
    
}
