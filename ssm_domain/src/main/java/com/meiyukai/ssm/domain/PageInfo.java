package com.meiyukai.ssm.domain;

import java.io.Serializable;
import java.util.List;

public class PageInfo <T> implements Serializable {
    private Integer totalPages; //总页数
    private Integer totalCount; //总记录数
    private Integer pageNum=1;  //当前页
    private Integer pageSize=2;  //每页显示的记录数
    private List<T>  list;      // 表格数据内容

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalPages=" + totalPages +
                ", totalCount=" + totalCount +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }


}
