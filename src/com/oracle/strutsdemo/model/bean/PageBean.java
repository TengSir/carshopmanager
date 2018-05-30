package com.oracle.strutsdemo.model.bean;

import java.io.Serializable;

public class PageBean    implements Serializable{

	private int nowPage;
	private int previousPage;
	private int nextPage;
	private int allPages;
	private  int everPageCount;
	private int allCount;
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getAllPages() {
		return allPages;
	}
	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}
	public int getEverPageCount() {
		return everPageCount;
	}
	public void setEverPageCount(int everPageCount) {
		this.everPageCount = everPageCount;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	@Override
	public String toString() {
		return "PageBean [nowPage=" + nowPage + ", previousPage=" + previousPage + ", nextPage=" + nextPage
				+ ", allPages=" + allPages + ", everPageCount=" + everPageCount + ", allCount=" + allCount + "]";
	}
	
}
