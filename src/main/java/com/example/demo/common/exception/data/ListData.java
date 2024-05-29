package com.example.demo.common.exception.data;

import java.util.List;

public class ListData<T> extends BaseData {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
}
