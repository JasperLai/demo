package com.example.demo.common.exception.data;


import com.github.pagehelper.PageInfo;

public class ListDataFactory {

    public static <T> ListData<T> createListData(PageInfo<T> pageInfo) {
        ListData<T> listData = new ListData<>();
        listData.setList(pageInfo);
        return listData;
    }
}
