package com.example.demo.common.exception.data;


import com.github.pagehelper.PageInfo;

public class ListData<T> extends BaseData {

    private PageInfo<T> list;

    public PageInfo<T> getList() {
        return list;
    }

    public void setList(PageInfo<T> list) {
        this.list = list;
    }
   
    
}
