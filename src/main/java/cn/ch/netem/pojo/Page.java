package cn.ch.netem.pojo;

public class Page {
 private Integer pageSize=2;
 private Integer pageCount;
 private Integer itemCount;
 private Integer currentPage=1;
 private Integer begin;
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getPageCount() {
	return pageCount;
}
public void setPageCount(Integer pageCount) {
	this.pageCount = pageCount;
}
public Integer getItemCount() {
	return itemCount;
}
public void setItemCount(Integer itemCount) {
	this.itemCount = itemCount;
	this.pageCount= itemCount%pageSize==0?itemCount/pageSize:itemCount/pageSize+1;
	this.begin=(currentPage-1)*pageSize;
}
public Integer getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(Integer currentPage) {
	this.currentPage = currentPage;
}
public Integer getBegin() {
	return begin;
}
public void setBegin(Integer begin) {
	this.begin = begin;
}

}
