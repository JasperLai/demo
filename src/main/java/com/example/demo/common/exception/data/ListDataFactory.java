package com.example.demo.common.exception.data;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class ListDataFactory {

    public static <T> ListData<T> createListData(PageInfo<T> pageInfo) {
        ListData<T> listData = new ListData<>();
        listData.setList(pageInfo.getList());
        listData.setSuccess(true);
        listData.setTotal(pageInfo.getTotal());
        listData.setPageSize(pageInfo.getPageSize());
        listData.setPageNum(pageInfo.getPageNum());
        return listData;
    }
}
